**IOT AGRICULTURAL FIELD MONITORING SYSTEM**

**IOT and Agriculture:-**
Internet of things is playing very crucial role in every sector as well as farming also.
The farm fertility and need to check whether the plantation of a particular species is positive
towards Hydroponic or not .By considering these segments and creating a lot of awareness
among farmers about IOT results in implementation as well as more productivity .Due to that
we can see some change in the farming sector scales in INDIA as it is the biggest sector and
backward sector with less deployment of technology .

**Circuit Diagram:-**
![alt text](Firtzing circuit/CD.jpg "Circuit Diagram")

**Block Diagram:-**

**Hardware:-**

![alt text](Block Diagram/photo1.jpg "Hardware block diagram")

**Database [backend]:-**
![alt text](Block Diagram/image.png "Database block diagram")

**Data Flow**

![alt text](Block Diagram/photo_2020-11-26_21-19-17.jpg "Data flow block diagram")

**Graphical view**
![alt text](Block Diagram/photo_2020-11-26_21-16-34.jpg "Graphical view")


**Working:-**
For each node there will be a NODE MCU linked . so that, for a particular area of field the data gets transferred to database. We can keep N number of nodes based on the farm area . Here in this project we took default 4 nodes for a user who registered (But by default all the nodes database will be disabled).When he/she registers the device then we will give the access to database to store values. Till now we seen how to transfer data to database. Then the next step is to display the  data values in the web page for remote access of data. In this scenario the data of sensors is private means it cannot be accessed by any others who registered. Only the owner can authenticate the data securely.

**Requirements:-**
**Hardware:-**
- Arduino UNO + ESP8266
- Soil moisture sensor
- GYML8511 UV sensor
- Optical dust sensor
- Temperature and humidity sensor

**Software : -**
- XAAMP application 
  1. My SQl database
  2. apache server[local]
  3. Visual studio code or any other editors
- Required languages 
  1. HTML5
  2. CSS [online templates preferable]
  3. PHP [or any language that can communicate with front and backend]
  4. Arduino

**UV and DUST effects on plant growth**

**DUST :**
Dust may affect photosynthesis, respiration, transpiration and allow the penetration of phytotoxic gaseous pollutants.
Visible injury symptoms may occur and generally there is decreased productivity. 
Most of the plant communities are affected by dust deposition so that community structure is altered.But dust also has many negative impacts on agriculture,
including reducing crop yields by burying seedlings, causing loss of plant tissue, reducing photosynthetic activity and increasing soil erosion.
Reductions in visibility due to airborne dust also have an impact on air and land transport.

**UV :**
UV light can speed up the germination process for starting seeds when grown indoors.
As growers transplant seedlings to more intense light sources, UV strengthens the plants, better preparing them for high intensity light.
Generally UV light wavelength is divided into three ranges,
UV-A :315-400nm
UV-B :280-315nm
UV-C :180-280nm

From the above three ranges , each of them UV range results in different plant growth, 
for example : 
UV-B light increases plant photosynthesis at the same time it is dangerous for human skin and it shows effects on plants
growth like decrease in height of plant , length of leaves..

UV-C UV-C light can increase branching At appropriate dosage rates, UV-C light can increase branching on some plant species.
This effect avoids the need to pinch plants and to apply plant growth regulators. Delayed flowering is also obvious on UV-C treated plants.

**Future Implementations:-**
There so many factors we can include in this project to extract more data and .
1) We need to include status of the node's covering area (Ex. good ,average ,bad) based on the sensor 
   data.
2) Some best practices in website for good farming and suggestions based on the status of the area.
3) Usage of cloud computing , Directly hosting this site under a cloud computing vendor makes it very 
   simple and clear .We can directly make our website public so that any person at any area can access.
4) At last , The biggest predictive analysis of the next month or year values of farm. This requires alot 
   computing and ML algorithms . We hope implementation of predictive algorithms using cloud computing 
   makes better result. If not we need to switch for automation scenario in farms. 

