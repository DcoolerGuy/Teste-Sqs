echo
aws --endpoint http://localhost:4566 --profile localstack ssm put-parameter --name "config/testesqs_localstack/sqsFila" --value "sqsFila" --type String