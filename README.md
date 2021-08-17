# Tasks

Repository presenting examples for Zuehlke coding interviews for Senior Engineer.

In a pair programming interview you are given the chance to solve an algorithmic challenge.

The challenge is not difficult but approaching it correctly is important.


## My personal experience
The session takes about 1 hour.

Only what you key-in matters, not what you describe.
Hence, if you are eager to create a verbose code to achieve a solution fast and do refactoring by relying on your test eventually -  it will fall on your toes.
They cut you of very quick, so don't expect too much of a patience. They might also help you out or ask some questions to bring you back on the right track :)


* align naming of your tests with your actual code
* do apply refactoring immediately
* don't keep global initialization in the method solving the algorithm to save time, put it immediately in the constructor or wherever it belongs
* don't focus on edge cases or illegal inputs, handling those does not count. If you are in doubt ask.
* normal for loops to iterate Strings are seen as bad style - prefer using something like streams API even you think it would be overkill.
* while you could think keeping the static method construct they provide to run the algorithm would be sufficient for the task at hand, it actually is NOT.
Create a proper class, avoid static.
