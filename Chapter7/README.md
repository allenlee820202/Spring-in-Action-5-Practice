# REST
## RESTful Controller
## Enabling hyperlinks
### Auto generate the hyperlink using resources
### Create resource assemblers
* Assemble data type used at the back end to the resource type
* ```toResource``` method transforms each type of class to its corresponding resource type one by one.
### Decouple the data class name and json column by adding ```@Relation``` tag in ```Resouce``` class.
Add ```@Relation(value = "taco", collectionRelation = "tacos")``` in front of the class definition.
