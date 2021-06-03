># _This is considered the second phase of our software development for the SAD project._


## Deliverables:

> Following files are uploaded in this directory.

1. **Detailed - Refined design documents**

- detailing important diagrams of our architecture, including use-case diagrams, class-diagrams, sequence diagrams.

2. **A scientific report in two-column format** 

- containing INTRODUCTION , RELATED WORK, METHODOLOGY (DESIGN)

>## Sequence Diagram for UseCase: “Bid on product”
>`Architectural challenges of our system was handling multiple concurrent transactions and updating the product price in real time for ongoing bidding processes.`

There will be many users active on the system and they will be able to bid on the products. But multiple users may place bids on the same product at the same time.
If the product is being bided by someone, there will be multiple users who will be on the same page waiting or trying to bid. If one bid is updated, other users must instantly see the updated bid amounts on their systems. This must be nearly real-time.


![alt](/Bid-Buy-Sell-Project/Related%20Documents/Architectural%20Design%20Documents%20(After%20Mid%20Term)/image/BBS%20Sequence%20Diagram%20V2.png)

Above sequence diagram is for the use case 'Bid on product'. Here we have shown two actors as client 1 and client 2 and bidController, server, bidRepo and bid(Entity) as the object for the sequence diagram. As shown in the sequence, when client 1 and client 2 both request to update the bid amount simultaneously the timestamp taken here will be till nanosecond to diminesh the possibility of clicking the bid at the same time. Once, the request is send to the server, it will use locking to lock object and further proceed to updatet he bid entity. When the request from the second actor client 2 is sent to the server, say after 1 nanosecond, it will create another thread for the request and try to request the lock object, but since the thread 1 is already using it thread 2 will be sent to wait state until the lock is released by thread 1. After that, thread 2 will proceed to update the bid, and bid will be updated if the value is more than the latest bid amount. 

>## Architectural Design

![alt](/Bid-Buy-Sell-Project/Related%20Documents/Architectural%20Design%20Documents%20(After%20Mid%20Term)/image/Architectural%20Design.png)

#### _`**Project logo design to go green without throwing second hand product**`_
![alt](/Bid-Buy-Sell-Project/Related%20Documents/Architectural%20Design%20Documents%20(After%20Mid%20Term)/image/logo.png)

