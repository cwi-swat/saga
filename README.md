saga
====
SAGA is a run-time verifier for Java programs.  During execution of a Java program, SAGA intercepts method calls and method returns (``events''). SAGA then checks whether the trace of calls and returns conforms to a specification, given by the user.

The main distinguishing featuring of SAGA compared to other run-time checkers is that SAGA allows combining protocol-oriented properties and data-oriented properties in a single formalism. In particular, Attribute Grammar are used as specifications.  The underlying context-free grammar determines the order in which events should occur,  in other words: the context-free grammar specifies the desired control-flow of a Java program.  Attributes define properties of the data-flow of the program,  and assertions over these attributes specify the desired values of the attributes.

For further instructions, please see doc/manual.pdf.
