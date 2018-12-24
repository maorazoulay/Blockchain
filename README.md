# Blockchain
Used this guide: https://medium.com/@ssaurel/create-your-own-blockchain-in-30-minutes-dbde3293b390
to better understad how a blockchain works by writing the code behind it.

Block class:

  Where we create our blocks using the following fields:
    Index- number of block in the order of the chain
    Timestamp - exact time when the block was created
    Hash - SHA-256 Cryptographic Hash Function
    Previous Hash - each node points to the previous node using its hash
    Data - the data to be stored in the block (in cryptocurrencies it would be transactions)
    Nonce - will help determine the ever-changing difficulty of mining the blocks 

  In this class, all the magic of hashing blocks is happening using Java's MessageDigest class. 

Blockchain class:
  In this class we create the Blockchain's data structure (ArrayList<Block>) as well as the Genesis block upon intializing a new          blockchain.
  The class provides methods to add new blocks and validate them. We can also choose to validate the entire blockcahin by using the class' various validation methods.
  
Test class:
  We Intitialize a new blockchain and add 3 valid blocks to it and then check the validity of the blockchain.
  To further test the validation method of the entire blockchain, we add an invalid block and expect the output to be false upon          validation.
  
Finally, the output: 
  
Block #0
[PreviousHash : null
Timestamp : Mon Dec 24 18:15:43 EST 2018
Data : Genesis Block
Hash : 0000c7c0b3a22e34865d039934d65b56560ccec4a05efd32fb49ff6ec0e6c213]

Block #1
[PreviousHash : 0000c7c0b3a22e34865d039934d65b56560ccec4a05efd32fb49ff6ec0e6c213
Timestamp : Mon Dec 24 18:15:44 EST 2018
Data : Some transactions
Hash : 00004db53295c54d637526e12a31b266803c5453c115874b1a0c45bf06f82f98]

Block #2
[PreviousHash : 00004db53295c54d637526e12a31b266803c5453c115874b1a0c45bf06f82f98
Timestamp : Mon Dec 24 18:15:44 EST 2018
Data : Some more transactions
Hash : 0000de5e073341d24f5612575378e33b23e003940016634731d20a917e485d50]

Block #3
[PreviousHash : 0000de5e073341d24f5612575378e33b23e003940016634731d20a917e485d50
Timestamp : Mon Dec 24 18:15:44 EST 2018
Data : A bit more transactions
Hash : 00001790865b6a4d0cd626f2216cde82efa33aeed31f17b94f3569ecfdb97ce9]


Blockchain valid? true

Block #0
[PreviousHash : null
Timestamp : Mon Dec 24 18:15:43 EST 2018
Data : Genesis Block
Hash : 0000c7c0b3a22e34865d039934d65b56560ccec4a05efd32fb49ff6ec0e6c213]

Block #1
[PreviousHash : 0000c7c0b3a22e34865d039934d65b56560ccec4a05efd32fb49ff6ec0e6c213
Timestamp : Mon Dec 24 18:15:44 EST 2018
Data : Some transactions
Hash : 00004db53295c54d637526e12a31b266803c5453c115874b1a0c45bf06f82f98]

Block #2
[PreviousHash : 00004db53295c54d637526e12a31b266803c5453c115874b1a0c45bf06f82f98
Timestamp : Mon Dec 24 18:15:44 EST 2018
Data : Some more transactions
Hash : 0000de5e073341d24f5612575378e33b23e003940016634731d20a917e485d50]

Block #3
[PreviousHash : 0000de5e073341d24f5612575378e33b23e003940016634731d20a917e485d50
Timestamp : Mon Dec 24 18:15:44 EST 2018
Data : A bit more transactions
Hash : 00001790865b6a4d0cd626f2216cde82efa33aeed31f17b94f3569ecfdb97ce9]

Block #7                                               //As you can see, this the invalid block which is why we get a false
[PreviousHash : something false
Timestamp : Mon Dec 24 18:15:44 EST 2018
Data : Invalid Block
Hash : 00001e61bbeb4203c8f31297a693ce4de6c42583702f86585647edd836c2e8aa]


Blockchain valid? false


