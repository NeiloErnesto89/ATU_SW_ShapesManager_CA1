Please also provide a readme.txt file in your source directory. This should include the following:


Student Name: Neil Smyth

Student ID: L00177606

List of known bugs and/or omissions (leave blank if you don't know of any):

Link to github repo (optional): https://github.com/NeiloErnesto89/ATU_SW_ShapesManager_CA1

Any other info that you might deem important.

I didn't test (or add restraints) to constructing the shape objects, so I could put in a very large number which
would probably make the program crash or just totally cover the screen. SO I would suggest adding a lot more exceptions
and conditionals to catch any 'bad user' behaviour.

I used a Const file to store immutable variables, but then I stored both the 'displayName' and 'displayBoundingBox' bool vars
inside the ShapesManager class - it made sense at the time and I kept it.

Manual Tests:

All shapes rendered with correct fill or unfilled toggle
BoundBoxes correctly rendered
Filled/Unfilled toggling all shapes upon intersection (e.g. Circle & Rect)
RightClick toggles shapes filled (verfiy also in console)
RightClick on Circle - does nothing - as expected
RightClick on Rectangle - invokes moveTenUnits() method - works as expected
RightClick on Quadrilateral - invokes rotate90degs() method - works as expected