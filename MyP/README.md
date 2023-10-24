# Лабораторная работа №0 по JAVA


В данной лаборраторной работе использовались:
- Java 11.0.20
- текстовый редактор - nano
- github - ruabininAD
- Maven 3.9.5
- Git

## заголовок 
В данной лабораторной работе был сгенерирован maven проект с помощью команды `mvn archetype:generate -DgroupId=ru.spbstu.telematics.java -DartifactId=${ProjectName} -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false`





# Основная часть
## Установка JDK и JRE

Для установки на ОС Linux Ubuntu необходимо выполнить следующие команды в терминале.

```shell
sudo install openjdk-21-jdk
sudo install openjdk-21-jre
```

Проверка java:
```shell
java --version
```

openjdk 11.0.20.1 2023-08-24
OpenJDK Runtime Environment (build 11.0.20.1+1-post-Ubuntu-0ubuntu122.04)
OpenJDK 64-Bit Server VM (build 11.0.20.1+1-post-Ubuntu-0ubuntu122.04, mixed mode, sharing)

## Установка maven 


Для установки maven на ОС Linux Ubuntu необходимо выполнить следуюшую команду в терминале.

```shell
sudo install maven
```

Проверка Maven :

```shell
mvn --version
```

Apache Maven 3.6.3
Maven home: /usr/share/maven
Java version: 11.0.20.1, vendor: Ubuntu, runtime: /usr/lib/jvm/java-11-openjdk-amd64
Default locale: en, platform encoding: UTF-8
OS name: "linux", version: "5.15.90.1-microsoft-standard-wsl2", arch: "amd64", family: "unix"


## Установка git

```shell
sudo apt install git
```

настройка Git
```shell
git config --global user.name "ruabininAD" 
git config --global user.email "ruabiniAD@edu.spbstu.ru" 
```


## Созлание проекта Maven.

``` shell

mvn archetype:generate -DgroupId=ru.spbstu.telematics.java -DartifactId=M2t -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false
cd SnakeAdding
``` 

Полученный проект содержал программу Hello World



В файл pom.xml были добавленны библиотеки `commons-math3` версии 3.6 и `commons-io` версии 2.5, обновлена версия junit до 4.12.
Добавлены  плагины запуска `maven-compiler-plugin` версии 3.8.1  и `exec-maven-plugin` версии 1.6.0.

После реализации программы, перемножающей матрицы с помощью метода multiply из библиотеки  commons.math3, для запуска программы необходимо выполгнить следующие команды: 
- mvn compile
- mvn exec:java

Команда mvn compile в Maven используется для компиляции исходного кода вашего проекта. Эта команда вызывает плагин компиляции, который компилирует исходные файлы Java из каталога src/main/java в байт-код Java и сохраняет скомпилированные классы в каталог target/classes.

В частности, команда **mvn compile** выполняет следующие действия:

Проверка зависимостей: Maven проверяет, что все зависимости, указанные в файле pom.xml, доступны и загружены. Если какие-либо зависимости отсутствуют, Maven попытается их загрузить из центрального репозитория или других источников.

Компиляция исходного кода: Maven находит исходные файлы Java в каталоге src/main/java вашего проекта и использует компилятор Java для преобразования их в байт-код Java.

Сохранение скомпилированных классов: Скомпилированные классы сохраняются в каталог target/classes в вашем проекте.

Команда **mvn exec:java** в Maven используется для выполнения Java-приложения прямо из среды сборки Maven. Эта команда использует плагин Maven Exec Plugin, который предоставляет возможность запуска Java-приложений, определенных в вашем проекте.

Когда вы выполняете mvn exec:java, Maven будет искать класс с методом main в вашем проекте и выполнит его.



Основной код
Код перемножения матриц, заданных в коде

a ={{33, 15, 4}, {52, 42, 2}}
b ={{1, 5}, {3, 2}, {4, 2}}

result ={{94, 203}, {186, 348}}


```java

package ru.spbstu.telematics.java;

import org.apache.commons.math3.linear.MatrixUtils;
import org.apache.commons.math3.linear.RealMatrix;

public class App {
   public static void main(String[] args) {
        // Определение первой матрицы
        double[][] matrixData1 = {{1, 2, 3}, {4, 5, 6}};
        RealMatrix matrix1 = MatrixUtils.createRealMatrix(matrixData1);

        // Определение второй матрицы
        double[][] matrixData2 = {{7, 8}, {9, 10}, {11, 12}};
        RealMatrix matrix2 = MatrixUtils.createRealMatrix(matrixData2);

        // Умножение матриц
        RealMatrix product = matrix1.multiply(matrix2);

        // Вывод результата
        System.out.println("Результат умножения матриц:");
        double[][] result = product.getData();
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }
}
```
## Unit тесты
реализован класс AppTest, в котором находится  Unit-тест, рассматривающий произведение матрицы:

| 33  15  4 |   | 1  5 |   | 94   203  |
| 52  42  2 | x | 3  2 | = | 186  348  |



```java
package ru.spbstu.telematics.java;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import org.apache.commons.math3.linear.MatrixUtils;
import org.apache.commons.math3.linear.RealMatrix;
public class AppTest extends TestCase
{
    public AppTest(String testName)
    {
        super(testName);
    }

    public static Test suite()
    {
        return new TestSuite(AppTest.class);
    }

    public void testMatrixMultiplication()
    {
        double[][] matrixData1 = {{33, 15, 4}, {52, 42, 2}};
        RealMatrix matrix1 = MatrixUtils.createRealMatrix(matrixData1);

        double[][] matrixData2 = {{1, 5}, {3, 2}, {4, 2}};
        RealMatrix matrix2 = MatrixUtils.createRealMatrix(matrixData2);

        RealMatrix product = matrix1.multiply(matrix2);

        double[][] expectedData = {{94, 203}, {186, 348}};
        RealMatrix expected = MatrixUtils.createRealMatrix(expectedData);

        double epsilon = 1e-9; // Define a small value for comparing floating point numbers

        assertTrue(expected.subtract(product).getNorm() < epsilon);
    }
}
```
Заключение
Эта задача ориентирована на использование основных концепций Java и системы контроля версий Git для управления проектами и системы контроля зависимостями maven.
