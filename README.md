## Micronaut 3.4.2 Documentation

- [User Guide](https://docs.micronaut.io/3.4.2/guide/index.html)
- [API Reference](https://docs.micronaut.io/3.4.2/api/index.html)
- [Configuration Reference](https://docs.micronaut.io/3.4.2/guide/configurationreference.html)
- [Micronaut Guides](https://guides.micronaut.io/index.html)
---

- [Shadow Gradle Plugin](https://plugins.gradle.org/plugin/com.github.johnrengelman.shadow)
## Feature http-client documentation

- [Micronaut HTTP Client documentation](https://docs.micronaut.io/latest/guide/index.html#httpClient)



Good day. I'm currently trying to get Hashicorp Vault working as described in https://docs.micronaut.io/latest/guide/#distributedConfigurationVault but it seems the documentation might be out of date. Copying the described bootstrap.yml into a plain starter project leads to some issues (most resolvable, like missing dependencies, config-client needs to be enabled, 
some additional properties like URI needs to be set). I'm currently stuck at the following config 
(consul was also activated just for playing around):
```
#spring.cloud.config.enabled: true
micronaut:
  application:
    name: keyvault
  config-client:
    enabled: true
consul:
  client:
    default-zone: "localhost:8500"
    config:
      enabled: true
vault:
  client:
    log-level: trace
    uri: localhost:1234
    token: atotallysecrettoken
    config:
      enabled: true
    kv-version: V2
```

Which fails to run the application with the exception: 
```No bean of type [io.micronaut.http.client.loadbalance.DiscoveryClientLoadBalancerFactory] exists```
In some other message here I read that the http client might simply not be present during bootstrapping, 
so how do I proceed here? 
