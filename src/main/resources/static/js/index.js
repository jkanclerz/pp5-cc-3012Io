async function getCards() {
    const cardsIndexURL = "/api/cards/balances"
    const response = await fetch(cardsIndexURL)
    const data = await response.json()
    return data;
}

const handleAppendCards = (cards, cardsListEl) => {
    cards
        .map(card => `<li>${card.number} | ${card.saldo}</li>`)
        .forEach(cardHtml => cardsListEl.insertAdjacentHTML("beforeend", cardHtml))
}

document.addEventListener("DOMContentLoaded", () => {
    const cardsListEl = document.querySelector('.cards__list')
    getCards()
        .then(cards => handleAppendCards(cards, cardsListEl));
});



