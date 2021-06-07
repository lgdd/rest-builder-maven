# REST Builder with Maven

Example of Liferay REST builder using Maven.

## Usage

Initialize Liferay Bundle:
```shell
./mvnw bundle-support:init
```

Deploy the code:
```shell
./mvnw bundle-support:deploy
```

If you change the `rest-openapi.yml` file:
```shell
./mvnw rest-builder:build
```
> To run under `./modules/headless-todo/headless-todo-impl`

## License

[MIT](LICENSE)