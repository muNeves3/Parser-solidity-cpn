// SPDX-License-Identifier: GPL-3.0

pragma solidity ^0.8.4;

contract EleicaoPonderada {
    address public admin;
    mapping(address => uint) public pesoEleitor;
    uint[5] public votosProposta;

    constructor() {
        admin = msg.sender;
    }

    function definirPeso(address eleitor, uint novoPeso) public {
        require(msg.sender == admin);
        pesoEleitor[eleitor] = novoPeso;
    }

    function votarProposta(uint idProposta) public {
        require(pesoEleitor[msg.sender] > 0);
        votosProposta[idProposta] += pesoEleitor[msg.sender];
    }
}