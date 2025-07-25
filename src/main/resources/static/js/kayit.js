document.getElementById('kayitOlButonu').addEventListener('click', function (event) {
    event.preventDefault(); 

    const formData = new FormData(document.getElementById('kayitFormu'));
    const data = {};
    formData.forEach((value, key) => { 
        if (value.trim() === '') {
            alert(key + ' alanı boş olamaz!');
            return;
        }
        data[key] = value.trim(); 
    });

   

    fetch('/kayit', {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(data)
    })
    .then(response => {
        if (response.status === 200 || response.status === 201) { 
            return response.text();
        } else { 
            throw new Error('Beklenmeyen durum kodu: ' + response.status);
        }
    })
    .then(data => {
        alert(data); 
        window.location.href = "/giris"; 
    })
    .catch(error => {
        alert('Hata: ' + error.message);
    });
});
