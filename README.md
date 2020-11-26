# SimpleGraph

[![Build Status](https://travis-ci.org/DanySpin97/SimpleGraph.svg?branch=master)](https://travis-ci.org/DanySpin97/SimpleGraph)
[![Codacy Badge](https://api.codacy.com/project/badge/Grade/fe4bb3c9df4c4e80a737606dd7eac509)](https://www.codacy.com/app/danyspin97/SimpleGraph?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=DanySpin97/SimpleGraph&amp;utm_campaign=Badge_Grade)

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
