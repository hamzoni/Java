<script>
    let actionBtn = document.querySelectorAll("[feature]");
    axios.defaults.headers.post['Content-Type'] = 'application/x-www-form-urlencoded; charset=UTF-8';
    for (let i = 0; i < actionBtn.length; i++) {
        actionBtn[i].addEventListener("click", function () {
            let ft = this.getAttribute("feature");
            let id = this.getAttribute("target");
            if (ft == "delete") {
                axios.post(ft, {
                    id: id
                })
                .then(response => {
                    window.location.reload();
                })
                .catch(error => console.log(error));
            } else {
                window.location.href = ft + "?id=" + id;
            }
        });
    }
</script>