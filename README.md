# TrainingCenterApi
step 1 : download zip folder and extrect it
setp 2 : import folder in IDE
step 3 : open postman and put the url

get : localhost:8080/trainingcenter/
post : localhost:8080/trainingcenter/

put data in json formate :-

{
    "centerName" : "PCTI",
    "centerCode" : "PCTI000E589",
    "capacity" : 600,
    "address" : {"detailedAddress":"House No 858 Pritampura",
    "city":"Delhi",
    "state" : "Delhi",
    "pincode" : "524847"},
    "course" : [{"courseName":"C Language"},{"courseName":"Java"},{"courseName":"Python"},{"courseName":"Php"}],
    "contectEmail" : "suraj@gmail.com",
    "contectPhone" : "5645875454"
}
