# Linear_Algebra_Utilities
 A repository for Linear-Algebra utilities, like "Put_in_RREF".

<h3>Put_in_RREF.py</h3>

Put_in_RREF parses a string representation of a matrix from a command-line argument into a numpy matrix and outputs a version of the matrix in Reduced Row Echelon Form. Additionally, Put_in_RREF outputs each step of the process of putting the inputted matrix into RREF.

<h5>Using Put_in_RREF.py on a Windows-10 PC</h5>

<ol>
    <li>Install Python 3.9.1 and pip.</li>
    <li>Clone repository.</li>
    <li>Open PowerShell in repository root directory.</li>
    <li>Install dependencies with "pip install -r requirements.txt"</li>
    <li>Run "python Put_in_RREF.py 'a11, a12, a13; a21, a22, a23'". Make sure all matrix values are numerical values each with at least one digit to the right of the decimal point.</li>
    <li>To save output to a text file, pipe output using "python Put_in_RREF.py 'a11, a12, a13; a21, a22, a23' | Out-File Example_Process.txt".</li>
</ol>