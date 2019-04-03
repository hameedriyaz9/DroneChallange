# DroneChallange
Drone Delivery Challenge
Drone Delivery Challenge Java Code

Run through command line:
Redirect to src/com/java folder of the project.

For compiling: javac -d ../../../bin *.java
For Run (Redirect to bin folder in the project): java com.java.TestMain D:/orders.txt

output: file path will be shown as output which will be downloaded to your local directory.

Traversing Steps:

1) Reading the input file from the arguments.
2) Preparing the grid using two dimension array of maximum size the direction gets.
3) Considering the center point of the Array as Ware House point.
4) Taking the center point of the array traverse through its adjacent elements diagonally first and left, right, top and bottom next. 
    i) Here for each move to Vertical or Horizontal grid block we are assuming the distance covered in 1 Minutes. 
    ii) Also, maintaining an array called visited in-order to get track of all visited grid blocks. Once visited will visit again.
5) If the flag returned is false in (4), now traverse through the top left adjacent grid block to the center grid. 
    i) Again, we will traverse diagonally first and left, right, top, bottom next. 
    ii) This traverse will cover maximum of grids on left side of the array.
6) If the flag returned is false in (5), now traverse through the bottom right adjacent grid block to the center grid. 
    i) Again, we will traverse diagonally first and left, right, top, bottom next. 
    ii) This traverse will cover all of grid blocks both remained on the left side and blocks on right side of the center grid block.
        (4), (5), (6) is done for all the orders got from the input file.
7) Once all the orders traverse is done, we calculate and align the orders based in ascending order based on the time taken for each order.
8) NPS is calculated based on % of promoters - % of detractors.
9) The output file will be downloaded to local system and path of the file will be shown on the command line as output.
