// DOM manipulation
const allLis = document.querySelectorAll("li");

/*
for (let i = 0; i < allLis.length; i++) {
	allLis[i].innerText = "Some new text";
}

for (let li of allLis) {
	li.innerHTML = "another new <b> TEXT </b>";
}

*/
// styles are camel cased
const h1 = document.querySelector("h1");

// add style value inline (html)
// they override css style. it is better not to use them
//h1.style.color = "Blue";
/*
const colors = ["red", "orange", "blue"];
allLis.forEach((li, i) => {
	const color = colors[i];
	li.style.color = color;
});
*/
// getComputedStyle
const h1Style = getComputedStyle(h1);
console.log(h1Style.color);
console.log(h1Style.fontSize);

// using classList
const todo = document.querySelector("#todos .todo");
todo.classList.toggle("todo");

// creating elements
const newh2 = document.createElement("h2");
newh2.innerText = "This is new element";
newh2.classList.add("special");


//// using appendChile
const section = document.querySelector("section");
section.appendChild(newh2);
