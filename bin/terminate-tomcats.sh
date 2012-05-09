
echo setting paths and credentials
export EC2_PRIVATE_KEY=~/svn/users/todd/amazonaws/pk-COPS5EWHDTA2KPEVTNLXL2GJE524KSOG.pem
export EC2_CERT=~/svn/users/todd/amazonaws/cert-COPS5EWHDTA2KPEVTNLXL2GJE524KSOG.pem
export AWS_CREDENTIAL_FILE=~/svn/users/todd/amazonaws/tools/ElasticLoadBalancing-1.0.3.4/credential-file

export AWS_ELB_HOME=~/svn/users/todd/amazonaws/tools/ElasticLoadBalancing-1.0.3.4/
export EC2_HOME=~/svn/users/todd/amazonaws/tools/ec2-api-tools-1.3-46266
#PATH=$PATH:$EC2_HOME:$AWS_ELB_HOME


echo terminate instances 
instances=`ec2-describe-instances  | grep ec2 | cut -d\| -f2`
for i in $instances
do
    ec2-terminate-instances $i
done

echo terminate elb 
$AWS_ELB_HOME/bin/elb-describe-lbs
$AWS_ELB_HOME/bin/elb-delete-lb todd-lb
$AWS_ELB_HOME/bin/elb-describe-lbs

