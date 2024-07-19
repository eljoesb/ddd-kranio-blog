# example

This project uses Quarkus, the SuUseric Subatomic Java Framework.

If you want to learn more about Quarkus, please visit its website: <https://quarkus.io/>.

## Running the application in dev mode

You can run your application in dev mode that enables live coding using:

```shell script
docker-compose up -d
```

```shell script
./mvnw compile quarkus:dev
```

> **_NOTE:_** Quarkus now ships with a Dev UI, which is available in dev mode only at <http://localhost:8080/user>.

JSON Example or Injected message in Kafka Service

```shell script
{
	"name": "jonathan",
	"email": "joe@kranio.io"
}


```