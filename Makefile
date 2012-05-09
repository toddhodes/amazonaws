
.phony: default load_on_amazon run_on_amazon

DATE := $(shell date +%s)


default: load_on_amazon run_on_amazon

load_on_amazon:
	aws put MYBUCKET/hadoop-classes.jar ../hadoop/all.jar
	aws put MYBUCKET/VpCellDB-observations-11-17-2009.txt ../hadoop/data/VpCellId/observations-11-17-2009.txt
	aws ls MYBUCKET/hadoop-classes.jar MYBUCKET/VpCellDB-observations-11-17-2009.txt


run_on_amazon:
	./tools/ruby-emr/elastic-mapreduce --create --jar s3n://MYBUCKET/hadoop-classes.jar --main-class com.wavemarket.hadoop.CellDB --arg s3n://MYBUCKET/VpCellDB-observations-11-17-2009.txt --arg s3n://MYBUCKET/output-$(DATE)
	./tools/ruby-emr/elastic-mapreduce --list --active

