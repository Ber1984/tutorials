#  The Concept
   The Monad is a design pattern popular in the functional programming world. However, it actually originated from a mathematical field called Category Theory. This article will focus on Monad's definition of the software engineering field. Although both definitions have many similarities, the software one and the field's jargon are more relevant to our context.

In short, a general concept is an object that can map itself to different results based on transformations.

# The Design Pattern
Monads are containers or structures that encapsulate values and computations. They must have two basic operations:
- Unit: monads represent a type that wraps a given value, and this operation is responsible for wrapping the value. For example, in Java, this operation can accept values from different types just by leveraging generics
- Bind: This operation allows transformation to be executed using the held value and returns a new monad value (a value wrap in the monad type)

Nonetheless, there are some properties that a monad has to obey:

- Left identity: when applying to a monad, it should yield the same outcome as applying the transformation to the held value
- Right identity: when sending a monad transformation (convert the value to a monad), the yield outcome must be the same as wrapping the value in a new monad
- Associativity: when chaining transformations, it should not matter how transformations are nested
One of the challenges of functional programming is to allow pipelining of such operations without losing readability. This is one of the reasons for adopting the concept of monads. The Monad is fundamental to the functional paradigm and helps implement declarative programming.