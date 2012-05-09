
.phony: all build load run

HADOOP_HOME=/ext/home/todd/src/hadoop-0.20.1/
HADOOP_VERSION=0.20.1
HADOOP_BIN=/ext/home/todd/src/hadoop-0.20.1/bin

all: build load run

build:
	javac -classpath $(HADOOP_HOME)/hadoop-$(HADOOP_VERSION)-core.jar -d classes Centroid.java
	jar -cvf centroid.jar -C classes/ .


load:
	ssh dmz 'echo "select * from WlanInfo" | mysql -ulp -plp lp' > wlaninfo
	$(HADOOP_BIN)/hadoop dfs -rm input/wlaninfo
	$(HADOOP_BIN)/hadoop dfs -put wlaninfo input/

run:
	#echo "you may need to 'bin/hadoop dfs -rmr output-wlan'"
	$(HADOOP_BIN)/hadoop dfs -rmr output-wlan
	$(HADOOP_BIN)/hadoop jar centroid.jar org.myorg.Centroid input/wlaninfo output-wlan
	$(HADOOP_BIN)/hadoop dfs -cat output-wlan/part*



