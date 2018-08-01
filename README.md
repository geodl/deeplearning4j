# Архитектура [deeplearning4j]  фреймворка для глубокого обучения
https://drive.google.com/drive/folders/1urykDEER9tFap2weFVq2qPh5mz-r7svu

# Архитектура [deeplearning4j] фреймворка для глубокого обучения. 
Обучение в Deeplearning4j осуществляется через кластеры. Нейронные сети обучаются параллельно по итерациям, процесс поддерживается архитектурами Hadoop-YARN и Spark. Deeplearning4j осуществляет также интеграцию с ядром архитектуры CUDA для осуществления чистых операций с GPU и распределения операций на графических процессорах.
![Image alt](https://i2.wp.com/mesutpiskin.com/blog/wp-content/uploads/2017/09/dl4j-eco-tr.jpg.jpg)

Deep Learning with DeepLearning4J and Spring Boot - Artur Garcia & Dimas Cabré @ Spring I/O 

https://www.youtube.com/watch?v=RlL9MNT-R3k


# Технология
Deeplearning4j реализована на языке Java и выполняется в среде, при этом совместима с Clojure и включает интерфейс (API) для языка Scala. Дополнительная библиотека ND4J открытого доступа обеспечивает вычисления на графических процессорах с поддержкой CUDA. Кроме того, имеются средства для работы с библиотекой на языке Python через фреймворк Keras.

Фреймворк позволяет комбинировать компоненты, объединяя обычные нейронные сети с машинами Больцмана, свёрточными нейронными сетями, автокодировщиками и рекуррентными сетями в одну систему. Кроме того, поддерживаются расширенные средства визуализации. Обучение проводится как с помощью обычных многослойных нейронных сетей, так и для сложных сетей, в которых определён граф вычислений.

# Распределённые вычисления
Обучение в Deeplearning4j осуществляется через кластеры. Нейронные сети обучаются параллельно по итерациям, процесс поддерживается архитектурами Hadoop-YARN и Spark. Deeplearning4j осуществляет также интеграцию с ядром архитектуры CUDA для осуществления чистых операций с GPU и распределения операций на графических процессорах.

# Научные расчёты для JVM
Deeplearning4j включает в себя класс для работы с n-мерным массивом данных в библиотеке ND4J. Это облегчает вычисления для научных задач на языках Java и Scala, функциональность при этом соответствует языку NumPy для Pythonа. Использование этих средств позволяет эффективно решать задачи линейной алгебры и матричных преобразований в практических приложениях.

# Библиотека векторизации DataVec для машинного обучения
Библиотека DataVec проводит векторизацию файлов в различных входных и выходных форматах методом, подобным MapReduce; при этом данные трансформируются в векторную форму. DataVec векторизирует табличный формат CSV, изображения, звуки, тексты, видео и временные последовательности данных

# Monorepo of Deeplearning4j

Welcome to the new monorepo of Deeplearning4j that contains the source code for all the following projects, in addition to the original repository of Deeplearning4j moved to [deeplearning4j](deeplearning4j):

 * https://github.com/deeplearning4j/libnd4j
 * https://github.com/deeplearning4j/nd4j
 * https://github.com/deeplearning4j/datavec
 * https://github.com/deeplearning4j/arbiter
 * https://github.com/deeplearning4j/nd4s
 * https://github.com/deeplearning4j/gym-java-client
 * https://github.com/deeplearning4j/rl4j
 * https://github.com/deeplearning4j/scalnet
 * https://github.com/deeplearning4j/jumpy

To build everything, we can use commands like
```
./change-cuda-versions.sh x.x
./change-scala-versions.sh 2.xx
./change-spark-versions.sh x
mvn clean install -Dmaven.test.skip -Dlibnd4j.cuda=x.x -Dlibnd4j.compute=xx
```
or
```
mvn clean install -Ptestresources -Ptest-native -Dlibnd4j.cuda=x.x -Dlibnd4j.compute=xx
```
Also included in the monorepo is a tutorial series in Zeppelin available in:
 * https://github.com/deeplearning4j/deeplearning4j/tree/master/deeplearning4j/dl4j-examples/tutorials
