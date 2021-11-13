# Getting Started

### Reference Documentation

* 原始项目执行，archetype目录
```java
mvn archetype:create-from-project
```
* maven命令行配置
```xml
 <profile>
	  <id>archetype</id>
	  <repositories>
	    <repository>
	      <id>archetype</id><!-- id expected by maven-archetype-plugin to avoid fetching from everywhere -->
	      <url>**http://192.168.31.242:8081/repository/maven-releases**/</url> /**本地私服**/
	      <releases>
	        <enabled>true</enabled>
	        <checksumPolicy>fail</checksumPolicy>
	      </releases>
	      <snapshots>
	        <enabled>true</enabled>
	        <checksumPolicy>warn</checksumPolicy>
	      </snapshots>
	    </repository>
	  </repositories>
	</profile>
  </profiles>

<activeProfiles>
  <activeProfile>archetype</activeProfile>
</activeProfiles>
```

执行

```shell
mvn archetype:generate     /
-DarchetypeGroupId=com.qingmu    / 
-DarchetypeArtifactId=rigger     /
-DarchetypeVersion=0.0.1    /
-DgroupId=com.qingmu    / 
-DartifactId=rigger   /  
-Dversion=1.0.0 /
-DarchetypeCatalog=local

```

