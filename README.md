# RoboBasic
A programming language called RoboBasic, aimed at a young audience of 10-12 year old children with the goal of making programming easier to learn at a young age. With RoboBasic, you can create a program for the game called RoboCode, where your program controls a tank, used to battle other tanks. An example program written in RoboBasic can be seen here:



    function void run()
      ahead(50).
      turnRight(90).
    endFunction

    when onHitByBullet()
      num a = gunHeading.
      num b = heading.
      turnGunRight(a - b).
      fire(1).
    endWhen

    when onHitWall()
      turnRight(180).
      ahead(20).
    endWhen

With the setup on this Github repository, you can write your own program and place it in the "Input.txt" file, run the "Implementation.java" file and then grab the produced "RoboBasic.java" file from the output directory, create a new directory called "RoboBasic" in RoboCodes source directory and place the file there.
