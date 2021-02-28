# Math_Utilities
 A repository for math utilities.

<h3>Put_in_RREF.py</h3>

Put_in_RREF parses a string representation of a matrix from a command-line argument into a numpy matrix and outputs a version of the matrix in Reduced Row Echelon Form. Additionally, Put_in_RREF outputs each step of the process of putting the inputted matrix into RREF.

<h5>Using Put_in_RREF.py on a Windows-10 PC</h5>

<ol>
    <li>Install Python 3.9.1 and pip.</li>
    <li>Clone repository.</li>
    <li>Open PowerShell in repository root directory.</li>
    <li>Install dependencies with "pip install -r requirements.txt"</li>
    <li>Run "python Put_in_RREF.py 'a11, a12, a13; a21, a22, a23'".<br/>
        Make sure matrix brackets are written as single quotes. <br/>
        Make sure all matrix values are present and are numerical values.<br/>
        Make sure row elements are separated by commas and rows are separated by semicolons.</li>
    <li>To save output to a text file, pipe output using "python Put_in_RREF.py 'a11, a12, a13; a21, a22, a23' | Out-File Example_Process.txt".</li>
</ol>
