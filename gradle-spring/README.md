## 解释
1. 当前示例是展示如何使用gradle编译spring-boot项目，使用gradle编译spring-boot项目，基本的jar包都能够从mavenCentral库中找到。只要在build.gradle文件中配置好对应的repositories即可。
2. build.gradle是使用gradle编译spring-boot项目最基础的配置。
3. 如果不是编译spring-boot，而是编译普通的java项目，则使用如下配置。
    ```
    plugins {
      id 'java'
    }

    repositories { 
      mavenCentral() 
    }
    sourceCompatibility = 1.8

    dependencies {}

    jar {
        archiveBaseName = 'hello-gradle'
        archiveVersion =  '0.1.0'
        manifest {
            attributes 'Main-Class': 'hello.HelloWorld'
        }
    }
    ```

### 编译
无论是linux还是window, 直接在根目录下执行 gradle build 即可