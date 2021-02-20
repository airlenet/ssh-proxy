# sshproxy-boot-starter
sshproxy-boot-starter

简介
--------
通过SSH端口转发功能，解决研发过程中网络不通的问题

支持本地端口转发，远程端口转发。

例如，通过SSH代理，访问数据库等（本地端口转发）

使用
--------

Download [the latest JAR][latestjar] or grab via Maven:
```xml
        <dependency>
            <groupId>com.airlenet.sshproxy</groupId>
            <artifactId>sshproxy-boot-starter</artifactId>
            <version>1.0.0</version>
        </dependency>
```
or Gradle:
```groovy
compile 'com.airlenet.sshproxy:sshproxy-boot-starter:1.0.0'
```

Snapshots of the development version are available in [Sonatype's `snapshots` repository][snap].

配置
```properties

## 本地端口转发 localhost:6000-->(172.16.11.100:22)-->127.0.0.1:3306

airlenet.sshproxy.enable=true
airlenet.sshproxy.mode=local # 本地端口转发
airlenet.sshproxy.host=172.16.11.100
airlenet.sshproxy.port=22
airlenet.sshproxy.user=root
airlenet.sshproxy.password=123456
airlenet.sshproxy.localPort=6000
airlenet.sshproxy.remoteHost=127.0.0.1
airlenet.sshproxy.remotePort=3306
```


License
-------

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.



 [latestjar]: https://search.maven.org/remote_content?g=com.airlenet.portforwarding&a=portforwarding-boot-starter&v=LATEST
 [snap]: https://oss.sonatype.org/content/repositories/snapshots/
