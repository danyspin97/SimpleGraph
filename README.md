# SimpleGraph

[![Java CI with Gradle](https://github.com/danyspin97/SimpleGraph/actions/workflows/gradle.yml/badge.svg)](https://github.com/danyspin97/SimpleGraph/actions/workflows/gradle.yml)
[![Codacy Badge](https://api.codacy.com/project/badge/Grade/fe4bb3c9df4c4e80a737606dd7eac509)](https://app.codacy.com/gh/DanySpin97/SimpleGraph/dashboard)
[![Coverage Status](https://codecov.io/gh/danyspin97/SimpleGraph/graph/badge.svg?token=IcZFSrU9li)](https://codecov.io/gh/danyspin97/SimpleGraph)

Basic graph interfaces and implementations in Java.

## Build the library

To build the libray on a Unix system run the following command:

```bash
./gradlew build
```

Or, if you are using a windows system:

```
gradlew.bat build
```

To generate the jar library file:

```bash
./gradlew jar
```

## Interfaces

- [x] Graphs
  - [x] Graph
  - [x] DirectedGraph
  - [x] WeightedGraph
  - [x] DirectedWeightedGraph

## Implementations

- [x] Graphs
  - [x] BaseDenseGraph
  - [x] BaseSparseGraph
  - [x] BaseDirectedSparseGraph
  - [x] Unweighted
    - [x] UndirectedDenseGraph
    - [x] UndirectedSparseGraph
    - [x] DirectedDenseGraph
    - [x] DirectedSparseGraph
  - [x] Weighted
    - [x] UndirectedWeightedDenseGraph
    - [x] UndirectedWeightedSparseGraph
    - [x] DirectedWeightedDenseGraph
    - [x] DirectedWeightedSparseGraph
- [x] Utilities
  - [x] FibonacciHeap

# LICENSE
This project is licensed under the [GPLv3 license](LICENSE).
