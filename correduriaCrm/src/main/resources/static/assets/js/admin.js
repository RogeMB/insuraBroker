let el = document.getElementById("wrapper");
let toggleButton = document.getElementById("menu-toggle");

toggleButton.onclick = function () {
    el.classList.toggle("toggled");
};


let openBut = document.getElementById("openButton");
let closeBut = document.getElementById("closeButton");

openBut.addEventListener('pointerup', appear);
closeBut.addEventListener('pointerup', disapp);

function appear() {
    openBut.classList.add("d-none");
    closeBut.classList.remove("d-none");

};

function disapp() {
    openBut.classList.remove("d-none");
    closeBut.classList.add("d-none");
};


let backtotop = select('.back-to-top')
if (backtotop) {
    const toggleBacktotop = () => {
        if (window.scrollY > 100) {
            backtotop.classList.add('active')
        } else {
            backtotop.classList.remove('active')
        }
    }
    window.addEventListener('load', toggleBacktotop)
    onscroll(document, toggleBacktotop)
};






