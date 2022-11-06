Please also provide a readme.txt file in your source directory. This should include the following:

** Please refer to my ReadME.md via Github to see more **

Student Name: Neil Smyth

Student ID: L00177606

List of known bugs and/or omissions (leave blank if you don't know of any):
I didn't see Quad test 2, so I was unable to add the Quadrilateral constructor to take in a particular
point to rotate the shape on (acting as the origin/center point) so I was not able to incorporate this logic.
However, I didn't come across any further bugs/omissions and the system seemed operating well according to the requirements.

Link to github repo (optional): https://github.com/NeiloErnesto89/ATU_SW_ShapesManager_CA1

Any other info that you might deem important.

Also, I didn't test (or add catch all restraints) to constructing the shape objects, so I could put in a very large number which
would probably make the program behaviour badly or just totally cover the screen. So I would suggest adding a lot more exceptions
and conditionals to catch any 'bad user' behaviour as well as a more robust testing suite on my behalf.

I used a Const file to store immutable variables, but then I stored both the 'displayName' and 'displayBoundingBox' bool vars
inside the ShapesManager class - it made sense at the time and I kept it.

Manual Tests to ensure the requirements were met:

- All shapes rendered with correctly fill or unfilled toggle
- BoundBoxes correctly rendered, clicking inside or outsider had desired outcome
- Filled/Unfilled toggling all shapes upon intersection (e.g. Circle & Rect) (verified also in console) 
- RightClick toggles shapes filled (verified also in console)
- RightClick on Circle - does nothing - as expected
- RightClick on Rectangle - invokes moveTenUnits() method - works as expected
- RightClick on Quadrilateral - invokes rotate90degs() method - works as expected

Thanks very much and reach out if more info is needed.