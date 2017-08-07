# sbr-ch-data-api
An API for use by sbr-api for accessing Company House data

[![license](https://img.shields.io/github/license/mashape/apistatus.svg)]() [![Dependency Status](https://www.versioneye.com/user/projects/596f195e6725bd0027f25e93/badge.svg?style=flat-square)](https://www.versioneye.com/user/projects/596f195e6725bd0027f25e93)

## API Endpoints

| method | endpoint                                   | parameters                    | example                                |
|--------|--------------------------------------------|-------------------------------|----------------------------------------|
| GET    | /v1/company?companyNumber=${companyNumber} | companyNumber: company_number | GET /v1/company?companyNumber=AB123456 |

## Environment Setup

* Java 8 or higher (https://docs.oracle.com/javase/8/docs/technotes/guides/install/mac_jdk.html)
* SBT (http://www.scala-sbt.org/)

```shell
brew install sbt
```

* VirtualBox (https://www.virtualbox.org/wiki/Downloads

### Hortonworks Sandbox VM Setup

To reduce complications with the install/setup of Hive/Hadoop etc, we will be using the Hortonworks Sandbox VM.

1. Download the VM (https://hortonworks.com/downloads/#sandbox)
2. Import the VM into VirtualBox, use default settings, but use at least 8GB of RAM, preferably 10GB.
3. Run the VM

Once the VM is running, you should be able to go to `localhost:8888` to see the dashboard.

### Getting Company House data into Hive

1. Download the Company House data (http://download.companieshouse.gov.uk/en_output.html)
2. Unzip it
3. Replace the header with 'Clean CSV Headers' section from the [CH Readme](CH.md)
4. Follow the instructions [here](https://hortonworks.com/hadoop-tutorial/how-to-use-hcatalog-basic-pig-hive-commands/#download-example-data), use the table definition from the [CH Readme](CH.md)

## Running

To run the `sbr-ch-data-api`, run the following:

``` shell
sbt api/run -Denvironment=local
```

## Assembly

To assemble the code + all dependancies into a fat .jar, run the following:

```shell
sbt assembly
```

## Contributing

See [CONTRIBUTING](CONTRIBUTING.md) for details.

## License

Copyright ©‎ 2017, Office for National Statistics (https://www.ons.gov.uk)

Released under MIT license, see [LICENSE](LICENSE) for details.