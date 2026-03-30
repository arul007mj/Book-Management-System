let myin1=document.querySelector("main>form>input")
let myhead2=document.querySelectorAll("main>form>h2")[1]
console.log(myin1)
console.log(myhead2)
let otp=Math.ceil(Math.random()*99999+99999);
console.log(otp)
let btn=document.querySelector("main>form>button")

myhead2.innerHTML+=otp

btn.addEventListener("click",()=>{
	myin1.value=otp;
	console.log(myin1)
})
