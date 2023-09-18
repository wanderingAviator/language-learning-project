
const divs = document.querySelectorAll('.card');


divs.forEach((div) => {
    div.addEventListener('click', () => {

        const id = div.getAttribute('id');
        

        switch (id) {
            case '1':
                alert('a');
                break;
            case '2':
                alert('b');
                break;
            case '3':
                alert('c');
                break;
            default:
                break;
        }
    });
});
