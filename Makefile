
.phony: default load_on_amazon run_on_amazon

DATE := $(shell date +%s)


default: load_on_amazon run_on_amazon

load_on_amazon:
	aws put wvmrkt/hadoop-classes.jar ../hadoop/all.jar
	aws put wvmrkt/VpCellDB-observations-11-17-2009.txt ../hadoop/data/VpCellId/observations-11-17-2009.txt
	aws ls wvmrkt/hadoop-classes.jar wvmrkt/VpCellDB-observations-11-17-2009.txt


run_on_amazon:
	./tools/ruby-emr/elastic-mapreduce --create --jar s3n://wvmrkt/hadoop-classes.jar --main-class com.wavemarket.hadoop.CellDB --arg s3n://wvmrkt/VpCellDB-observations-11-17-2009.txt --arg s3n://wvmrkt/output-$(DATE)
	./tools/ruby-emr/elastic-mapreduce --list --active

