reflection
==========

Serialization and De-Serialization using Java Reflection

Two Java classes MyAllTypesFirst and MyAllTypesSecond are designed with the data members having 
their names and types as given in serialized format in the text file MyAllTypes. This MyAllTypes 
text file is then parsed and deserialized to create MyAllTypesFirst and MyAllTypesSecond objects. 
Reflection is used to create the object depending on the value in the complexType element of the 
given MyAllTypes text file. The names of the data members are parsed and the corresponding setX 
methods are invoked to set the value for that data member. Then all MyAllTypesFirst and 
MyAllTypesSecond objects are compared and unique objects of both types are reported. In Serialize 
class, serializeObject() method takes a Java object and serializes it using the serialization 
protocol shown in MyAllTypes text file. All objects created by parsing the MyAllTypes text file 
are serialized and then stored in a new text file MyAllTypesCopy. Running a diff between 
MyAllTypes and MyAllTypesCopy text files did not showed any difference. 
