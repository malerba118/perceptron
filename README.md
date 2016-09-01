# Perceptron

Usage: java Main <threshold> <learningRate> <weight1> <weight2> <operation>

This example is a solution to a simple intelligent systems homework question.
I mainly just wanted to practice some object oriented design concepts I learned
from <a href="https://www.amazon.com/Practical-Object-Oriented-Design-Ruby-Addison-Wesley-ebook/dp/B0096BYG7C#nav-subnav">Practical Object-Oriented Design in Ruby<a>.

Example Run

```
javac *.java

java Main 0 .05 .5 -.1 OR

Epoch     X1        X2        ExpectedY ActualY   Error     W1        W2       
1         1         0         1         1         0         0.500000  -0.100000 
1         1         1         1         1         0         0.500000  -0.100000 
1         0         0         0         0         0         0.500000  -0.100000 
1         0         1         1         0         1         0.500000  -0.050000 
2         1         0         1         1         0         0.500000  -0.050000 
2         1         1         1         1         0         0.500000  -0.050000 
2         0         0         0         0         0         0.500000  -0.050000 
2         0         1         1         0         1         0.500000  0.000000  
3         1         0         1         1         0         0.500000  0.000000  
3         1         1         1         1         0         0.500000  0.000000  
3         0         0         0         0         0         0.500000  0.000000  
3         0         1         1         0         1         0.500000  0.050000  
4         1         0         1         1         0         0.500000  0.050000  
4         1         1         1         1         0         0.500000  0.050000  
4         0         0         0         0         0         0.500000  0.050000  
4         0         1         1         1         0         0.500000  0.050000 
```

This program also shows that xor is not linearly separable (the program runs forever on xor input because it's impossible for a single perceptron to learn this behavior).
