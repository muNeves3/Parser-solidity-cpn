contract Coin {
    address public minter;
    mapping(address => uint) public balances;

    event Sent(address from, address to, uint amount);

    constructor() {
        mint = msg.sender;
    }

    function mint(address receiver, uint amount) public {
        require(msg.sender == minter);
        increaseBalance(receiver, amount);
    }

    error InsufficientBalance (uint requested , uint available);

    function send ( address receiver , uint amount ) public {
        if ( amount > balances [ msg . sender ])
        revert InsufficientBalance ({
            requested : amount ,
            available : balances [ msg . sender ]
        });

        balances [ msg. sender ] -= amount ;
        increaseBalance ( receiver , amount );
        emit Sent (msg. sender , receiver , amount );
    }

    function increaseBalance ( address receiver , uint amount ) private {
        balances [ receiver ] += amount ;
    }
}