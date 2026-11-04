document.addEventListener('DOMContentLoaded', () => {
    const root = document.documentElement;
    const toggle = document.getElementById('themeToggle');

    // Ažuriranje izgleda dugmeta za promjenu teme
    function updateThemeButton() {
        if (!toggle) return;

        const dark = root.getAttribute('data-theme') === 'dark';

        toggle.innerHTML = dark
            ? '<i class="fa-solid fa-sun theme-icon"></i><span class="theme-label">Svijetli način</span>'
            : '<i class="fa-solid fa-moon theme-icon"></i><span class="theme-label">Tamni način</span>';

        toggle.setAttribute(
            'aria-label',
            dark ? 'Uključi svijetli način' : 'Uključi tamni način'
        );
    }

    updateThemeButton();

    // Promjena teme klikom na dugme
    if (toggle) {
        toggle.addEventListener('click', () => {
            const next =
                root.getAttribute('data-theme') === 'dark'
                    ? 'light'
                    : 'dark';

            root.setAttribute('data-theme', next);

            // Pamti odabranu temu i nakon osvježavanja stranice
            localStorage.setItem('amare-theme', next);

            updateThemeButton();
        });
    }

    // Automatska godina u footeru
    const year = document.getElementById('currentYear');

    if (year) {
        year.textContent = new Date().getFullYear();
    }

    // Animacije elemenata prilikom skrolanja
    const revealItems = document.querySelectorAll('[data-reveal]');

    if (
        'IntersectionObserver' in window &&
        !window.matchMedia('(prefers-reduced-motion: reduce)').matches
    ) {
        const observer = new IntersectionObserver((entries, obs) => {
            entries.forEach(entry => {
                if (entry.isIntersecting) {
                    entry.target.classList.add('is-visible');
                    obs.unobserve(entry.target);
                }
            });
        }, {
            threshold: 0.12,
            rootMargin: '0px 0px -35px 0px'
        });

        revealItems.forEach(item => observer.observe(item));
    } else {
        revealItems.forEach(item => {
            item.classList.add('is-visible');
        });
    }

    // Navigacija dobija sjenu kada korisnik skrola
    const nav = document.querySelector('.amare-nav');

    if (nav) {
        const onScroll = () => {
            nav.classList.toggle('nav-scrolled', window.scrollY > 30);
        };

        onScroll();

        window.addEventListener('scroll', onScroll, {
            passive: true
        });
    }

    // Pretraga jela na stranici menija
    const search = document.getElementById('mealSearch');
    const rows = [...document.querySelectorAll('.meal-row')];
    const empty = document.getElementById('noMealResults');

    if (search) {
        search.addEventListener('input', () => {
            const term = search.value.toLocaleLowerCase('bs');
            let visible = 0;

            rows.forEach(row => {
                const match = row.innerText
                    .toLocaleLowerCase('bs')
                    .includes(term);

                row.hidden = !match;

                if (match) {
                    visible++;
                }
            });

            if (empty) {
                empty.classList.toggle(
                    'd-none',
                    visible !== 0 || term.length === 0
                );
            }
        });
    }
});