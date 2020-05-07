## Linked List Simulator

### Objective 

To let users understand Linked Lists, recursion, inheritance, frames and listeners.

### Instructions

Write a graphical application for drawing and linking cars (or any other complex shaped object). The interface for the simulation should look something like the following:

![alt tag](https://raw.githubusercontent.com/bsheikh/Linked-List-Simulator/master/Images/1.png)

#### Figure 1 

The figure on the left shows the panel after the user has pressed the mouse in six locations to first create the truck, and then the five cars shown. The figure on the right shows the panel after car 3 has been hitched to the
truck and after car 1 has been selected and hitched to car 3. Note the line used to visually depict a vehicle’s trailer “hitch”.

![alt tag](https://raw.githubusercontent.com/bsheikh/Linked-List-Simulator/master/Images/2.png)

#### Figure 2

In the left figure, car 3 has been selected and hitched to car 4 and then car 2 has been selected and hitched to car 3. Car 5 is currently selected (indicated by the color red). In the right figure, cars 1, 4, and 2 have been linked and then car 1 has been selected. This causes the trailer of car 1 (car 4) and the trailer of car 4 (car 2) to also be selected. The user can now move cars 1, 4, 2 as a single unit. 

### Terminology

* Vehicle: Abstract class which is a superclass of classes Car and Truck. This class should contain variables and methods that are common to Car and Truck. The methods supply default behavior and may be overridden in Car and Truck.

* Trailer: This is not a class, but rather just a term that refers to a car attached to the hitch of another vehicle. So, in figure 1 on the right, car 3 is a trailer for the truck, and car 1 is a trailer for car 3. Class Vehicle should have an instance variable trailer of type Vehicle. This variable is set to refer to the towed vehicle object or is set to null (indicating there is no towed vehicle). 

### Functionality

1. You cannot use the mouse to select a towed vehicle. Only the lead vehicle can be selected.  When a lead vehicle is selected, the vehicle and its trailer (and the trailer’s trailer etc.) move as a single unit. We will refer to a trailer car, and the trailer’s trailer etc. as the “linked cars” .

2. When you draw a vehicle, you must recursively draw its trailer (which will cause the trailer's trailer to be drawn, etc.). 

