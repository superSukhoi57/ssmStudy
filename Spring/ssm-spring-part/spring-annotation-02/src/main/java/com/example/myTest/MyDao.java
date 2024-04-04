package com.example.myTest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
//给属性赋值！！
@Repository
public class MyDao {
    //1、直接赋值
    String str="Tony";

    //2、通过@value来赋值。eg：@value("16"),但它多用于引用配置文件！！
    @Value("${my.password}")//@Value(${xxxx：默认值})，默认值是当配置文件没有对应的值时就使用默认值！！！
    String password;
    /*
    在同一个父工程下的两个子工程中，一个子工程可以通过`@Value`注解来引用另一个子工程的`resources`目录下的文件。以下是实现这一目标的步骤：

1. 在父工程的`pom.xml`文件中，添加以下内容，以确保子工程之间的依赖关系正确：

```xml<modules>
  <module>子工程1</module>
  <module>子工程2</module>
</modules>
```

2. 在子工程1的`pom.xml`文件中，添加以下内容，以将子工程1的`resources`目录添加到类路径中：

```xml<build>
  <resources>
      <resource>
          <directory>src/main/resources</directory>
        </resource>
    </resources>
</build>
```

3. 在子工程2的`pom.xml`文件中，添加以下内容，以将子工程1作为依赖添加到子工程2中：

```xml<dependencies>
  <dependency>
      <groupId>子工程1的groupId</groupId>
      <artifactId>子工程1的artifactId</artifactId>
      <version>子工程1的版本</version>
    </dependency>
</dependencies>
```

     */


}
