document.getElementById("girisYapButonu").addEventListener("click", function (e) {
    e.preventDefault(); 

    const ad = document.getElementById("ad").value.trim();
    const sifre = document.getElementById("sifre").value.trim();

    if (!ad || !sifre) {
        alert("Lütfen tüm alanları doldurun!");
        return;
    }



    const data = { ad, sifre};

    fetch("/musterigiris", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(data)
    })
    .then(response => {
        if (response.status === 200) {
            return response.text(); 
        } else if (response.status === 401) {
            throw new Error("Hatalı kullanıcı adı veya şifre!");
        } else {
            throw new Error("Beklenmeyen durum kodu: " + response.status);
        }
    })
    .then(data => {
        console.log("Sunucudan gelen kullanıcı:", data);
        window.location.href = "/";
    })
    
    .then(data => {
        window.location.href = "/girisYap"; 
    })
    .catch(error => {
        alert("Hata: " + error.message);
    });
    
});
