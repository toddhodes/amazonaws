
echo setting paths and credentials

export EC2_PRIVATE_KEY=.....pem
export EC2_CERT=.........pem
export AWS_CREDENTIAL_FILE=....../credential-file

export AWS_ELB_HOME=tools/ElasticLoadBalancing-1.0.3.4/
export EC2_HOME=tools/ec2-api-tools-1.3-46266
#PATH=$PATH:$EC2_HOME:$AWS_ELB_HOME


echo checking for keypairs
$EC2_HOME/bin/ec2-describe-keypairs
./tools/aws describe-keypairs



echo aquire ec2 instances w/ tomcat image
ec2run ami-45e7002c -m -z us-east-1a  -k EC2-keypair -f /etc/init.d/tomcat  -n 2
ec2-describe-instances

$EC2_HOME/bin/ec2-authorize default -p 22
$EC2_HOME/bin/ec2-authorize default -p 80
$EC2_HOME/bin/ec2-authorize default -p 8080

echo creating elb 
$AWS_ELB_HOME/bin/elb-create-lb todd-lb --availability-zones us-east-1a --listener "protocol=http, lb-port=80, instance-port=8080"

echo query elb 
$AWS_ELB_HOME/bin/elb-describe-lbs
elb=`$AWS_ELB_HOME/bin/elb-describe-lbs | awk '{print $3}'`



$AWS_ELB_HOME/bin/elb-configure-healthcheck todd-lb --interval 30 --unhealthy-threshold 2 --healthy-threshold 2 --timeout 3  --target "http:8080/hostname.txt" --headers       

echo setup hostname.txt
names=`ec2-describe-instances  | grep ec2 | cut -d\| -f6`
for i in $names
do
    echo setting hostname $i
    echo $i > /tmp/hostname.txt
    scp root@$i /tmp/hostname.txt /usr/share/tomcat5/webapps/ROOT/hostname.txt
    echo GETing hostname $i
    GET http://$i:8080/hostname.txt
done


echo setup hostname.txt
instances=`ec2-describe-instances  | grep ec2 | cut -d\| -f2`
for i in $instances
do
    $AWS_ELB_HOME/bin/elb-register-instances-with-lb  todd-lb --instances $i
done

$AWS_ELB_HOME/bin/elb-describe-instance-health  todd-lb


echo illustrate round-robin
for i in {1..5}
do
  GET http://$elb/hostname.txt
done





# based on 
#   http://java.dzone.com/articles/clustering-java-web
# and 
#   http://paulstamatiou.com/how-to-getting-started-with-amazon-ec2
