<<<<<<< HEAD
window.BASE_URL =
=======
<<<<<<< HEAD
window.BASE_URL =
=======
const BASE_URL =
>>>>>>> 94a7a18f1bf8c674dd8860b156b541530868c5d1
>>>>>>> 877167939f9e10d949c292c821688475df3ee5be
    "http://localhost:8080";

// TOKEN
function token() {

    return localStorage.getItem(
        "token"
    );
}

<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> aa5d16b6e567a8aaff7c06c7e9e3255d2c4d890c
>>>>>>> 94a7a18f1bf8c674dd8860b156b541530868c5d1
>>>>>>> 877167939f9e10d949c292c821688475df3ee5be
// ROLE
function role() {

    return localStorage.getItem(
        "role"
    );
}

<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
=======
>>>>>>> ce25f670b89a25dd008aea6d4aae2b8058309c49
>>>>>>> aa5d16b6e567a8aaff7c06c7e9e3255d2c4d890c
>>>>>>> 94a7a18f1bf8c674dd8860b156b541530868c5d1
>>>>>>> 877167939f9e10d949c292c821688475df3ee5be
// MENSAJES
function showMessage(msg) {

    const message =
        document.getElementById(
            "message"
        );

    if (message) {

        message.innerText = msg;
    }
}

//
// LOGIN
//
async function login() {

    const username =
        document.getElementById(
            "loginUsername"
        ).value;

    const password =
        document.getElementById(
            "loginPassword"
        ).value;

    if (
        username === "" ||
        password === ""
    ) {

        showMessage(
            "Completa todos los campos"
        );

        return;
    }

    try {

        const res = await fetch(
            `${BASE_URL}/api/auth/login`,
            {
                method: "POST",

                headers: {
                    "Content-Type":
                        "application/json"
                },

                body: JSON.stringify({
                    username: username,
                    password: password
                })
            }
        );

        if (!res.ok) {

            showMessage(
                "Credenciales incorrectas"
            );

            return;
        }

        const data =
            await res.json();

        localStorage.setItem(
            "token",
            data.token
        );

        localStorage.setItem(
            "username",
<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> aa5d16b6e567a8aaff7c06c7e9e3255d2c4d890c
>>>>>>> 94a7a18f1bf8c674dd8860b156b541530868c5d1
>>>>>>> 877167939f9e10d949c292c821688475df3ee5be
            data.username
        );

        localStorage.setItem(
            "role",
            data.role
<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
=======
            username
>>>>>>> ce25f670b89a25dd008aea6d4aae2b8058309c49
>>>>>>> aa5d16b6e567a8aaff7c06c7e9e3255d2c4d890c
>>>>>>> 94a7a18f1bf8c674dd8860b156b541530868c5d1
>>>>>>> 877167939f9e10d949c292c821688475df3ee5be
        );

        window.location.href =
            "dashboard.html";

    } catch (error) {

        console.log(error);

        showMessage(
            "Error al iniciar sesión"
        );
    }
}

//
// REGISTRO
//
async function registerUser() {

    const username =
        document.getElementById(
            "regUsername"
        ).value;

    const firstname =
        document.getElementById(
            "regFirstname"
        ).value;

    const lastname =
        document.getElementById(
            "regLastname"
        ).value;

    const age =
        document.getElementById(
            "regAge"
        ).value;

    const password =
        document.getElementById(
            "regPassword"
        ).value;

    if (
        username === "" ||
        firstname === "" ||
        lastname === "" ||
        age === "" ||
        password === ""
    ) {

        showMessage(
            "Completa todos los campos"
        );

        return;
    }

    try {

        const res = await fetch(
            `${BASE_URL}/api/auth/register`,
            {
                method: "POST",

                headers: {
                    "Content-Type":
                        "application/json"
                },

                body: JSON.stringify({
                    username: username,
                    firstname: firstname,
                    lastname: lastname,
                    age: parseInt(age),
                    password: password
                })
            }
        );

        if (res.ok) {

            showMessage(
                "Usuario registrado"
            );

            setTimeout(() => {

                window.location.href =
                    "index.html";

            }, 1500);

        } else {

            showMessage(
                "Error al registrar"
            );
        }

    } catch (error) {

        console.log(error);

        showMessage(
            "Error del servidor"
        );
    }
}

//
// BIENVENIDA
//
window.onload = () => {

<<<<<<< HEAD
    //
    // SOLO PROTEGER DASHBOARD
    //
    if (
        window.location.pathname.includes(
            "dashboard.html"
        )
    ) {

        if (!token()) {

            window.location.href =
                "index.html";

            return;
        }
    }

=======
>>>>>>> 877167939f9e10d949c292c821688475df3ee5be
    const welcome =
        document.getElementById(
            "welcome"
        );

    if (welcome) {

        const username =
            localStorage.getItem(
                "username"
            );

        welcome.innerText =
            "Bienvenido " +
            username +
            " 👋";
    }
<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> aa5d16b6e567a8aaff7c06c7e9e3255d2c4d890c
>>>>>>> 94a7a18f1bf8c674dd8860b156b541530868c5d1
>>>>>>> 877167939f9e10d949c292c821688475df3ee5be

    if (
        role() === "ADMIN"
    ) {

        const adminButton =
            document.getElementById(
                "adminButton"
            );

        if (adminButton) {

            adminButton.style.display =
                "block";
        }
    }
<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
=======
>>>>>>> ce25f670b89a25dd008aea6d4aae2b8058309c49
>>>>>>> aa5d16b6e567a8aaff7c06c7e9e3255d2c4d890c
>>>>>>> 94a7a18f1bf8c674dd8860b156b541530868c5d1
>>>>>>> 877167939f9e10d949c292c821688475df3ee5be
};

//
// MOSTRAR EVENTOS
//
function showEvents() {

    document.getElementById(
        "eventsSection"
    ).style.display = "block";

    document.getElementById(
        "bookingsSection"
    ).style.display = "none";

<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> aa5d16b6e567a8aaff7c06c7e9e3255d2c4d890c
>>>>>>> 94a7a18f1bf8c674dd8860b156b541530868c5d1
>>>>>>> 877167939f9e10d949c292c821688475df3ee5be
    document.getElementById(
        "adminSection"
    ).style.display = "none";

<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
=======
>>>>>>> ce25f670b89a25dd008aea6d4aae2b8058309c49
>>>>>>> aa5d16b6e567a8aaff7c06c7e9e3255d2c4d890c
>>>>>>> 94a7a18f1bf8c674dd8860b156b541530868c5d1
>>>>>>> 877167939f9e10d949c292c821688475df3ee5be
    loadEvents();
}

//
// MOSTRAR RESERVAS
//
function showBookings() {

    document.getElementById(
        "bookingsSection"
    ).style.display = "block";

    document.getElementById(
        "eventsSection"
    ).style.display = "none";

<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> aa5d16b6e567a8aaff7c06c7e9e3255d2c4d890c
>>>>>>> 94a7a18f1bf8c674dd8860b156b541530868c5d1
>>>>>>> 877167939f9e10d949c292c821688475df3ee5be
    document.getElementById(
        "adminSection"
    ).style.display = "none";

<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
=======
>>>>>>> ce25f670b89a25dd008aea6d4aae2b8058309c49
>>>>>>> aa5d16b6e567a8aaff7c06c7e9e3255d2c4d890c
>>>>>>> 94a7a18f1bf8c674dd8860b156b541530868c5d1
>>>>>>> 877167939f9e10d949c292c821688475df3ee5be
    loadBookings();
}

//
<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> aa5d16b6e567a8aaff7c06c7e9e3255d2c4d890c
>>>>>>> 94a7a18f1bf8c674dd8860b156b541530868c5d1
>>>>>>> 877167939f9e10d949c292c821688475df3ee5be
// PANEL ADMIN
//
function showAdminPanel() {

    document.getElementById(
        "adminSection"
    ).style.display = "block";

    document.getElementById(
        "eventsSection"
    ).style.display = "none";

    document.getElementById(
        "bookingsSection"
    ).style.display = "none";

    loadAdminEvents();
}

//
// CARGAR EVENTOS ADMIN
//
//
// CARGAR EVENTOS ADMIN
//
<<<<<<< HEAD
//
// CARGAR EVENTOS ADMIN
//
=======
>>>>>>> 877167939f9e10d949c292c821688475df3ee5be
async function loadAdminEvents() {

    try {

        const res =
            await fetch(
<<<<<<< HEAD
                `${BASE_URL}/api/events?page=0&size=10`,
=======
                `${BASE_URL}/api/events`,
>>>>>>> 877167939f9e10d949c292c821688475df3ee5be
                {
                    headers: {
                        Authorization:
                            "Bearer " + token()
                    }
                }
            );

<<<<<<< HEAD
        const data =
            await res.json();

        //
        // SOPORTA PAGINACION
        //
        const events =
            data.content || data;
=======
        const events =
            await res.json();
>>>>>>> 877167939f9e10d949c292c821688475df3ee5be

        let html = "";

        events.forEach((e) => {

            html += `
                <div class="card">

                    <h3>
                        ${e.title}
                    </h3>

                    <p>
                        📍 ${e.venue}
                    </p>

                    <p>
                        📅 ${e.event_date}
                    </p>

                    <p>
                        👥 ${e.capacity}
                    </p>

                    <p>
                        💲 ${e.price_per_ticket}
                    </p>

                    <div class="admin-buttons">

                        <button
<<<<<<< HEAD
                            onclick='openEditModal(${JSON.stringify(e)})'>
=======
<<<<<<< HEAD
                            onclick='openEditModal(${JSON.stringify(e)})'>
=======
<<<<<<< HEAD
                            onclick='openEditModal(${JSON.stringify(e)})'>
=======
                            onclick="editEvent(${e.id_event})">
>>>>>>> aa5d16b6e567a8aaff7c06c7e9e3255d2c4d890c
>>>>>>> 94a7a18f1bf8c674dd8860b156b541530868c5d1
>>>>>>> 877167939f9e10d949c292c821688475df3ee5be

                            Editar

                        </button>

                        <button
                            onclick="deleteEvent(${e.id_event})">

                            Eliminar

                        </button>

                    </div>

                </div>
            `;
        });

        document.getElementById(
            "adminEvents"
        ).innerHTML = html;

    } catch (error) {

        console.log(error);

        showMessage(
            "Error cargando eventos admin"
        );
    }
}

//
// CARGAR EVENTOS
//

<<<<<<< HEAD
//
// CARGAR EVENTOS
//
//
// CARGAR EVENTOS
//
=======
<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
=======
// CARGAR EVENTOS
//
>>>>>>> ce25f670b89a25dd008aea6d4aae2b8058309c49
>>>>>>> aa5d16b6e567a8aaff7c06c7e9e3255d2c4d890c
>>>>>>> 94a7a18f1bf8c674dd8860b156b541530868c5d1
>>>>>>> 877167939f9e10d949c292c821688475df3ee5be
async function loadEvents() {

    try {

        const res = await fetch(
<<<<<<< HEAD
            `${BASE_URL}/api/events?page=0&size=10`,
=======
            `${BASE_URL}/api/events`,
>>>>>>> 877167939f9e10d949c292c821688475df3ee5be
            {
                headers: {
                    Authorization:
                        "Bearer " + token()
                }
            }
        );

<<<<<<< HEAD
        if (!res.ok) {

=======
<<<<<<< HEAD
        if (!res.ok) {

=======
<<<<<<< HEAD
        if (!res.ok) {

=======
<<<<<<< HEAD
        // VALIDAR RESPUESTA
        if (!res.ok) {

            if (res.status === 403) {

                showMessage(
                    "No autorizado"
                );

                return;
            }

>>>>>>> aa5d16b6e567a8aaff7c06c7e9e3255d2c4d890c
>>>>>>> 94a7a18f1bf8c674dd8860b156b541530868c5d1
>>>>>>> 877167939f9e10d949c292c821688475df3ee5be
            showMessage(
                "Error cargando eventos"
            );

            return;
        }

<<<<<<< HEAD
        const data =
            await res.json();

        //
        // SOPORTA PAGINACION
        //
        const events =
            data.content || data;

        let html = "";

        events.forEach((e) => {

            //
            // CALCULAR CUPOS
            //
            const availableSeats =
                e.availableSeats ??
                e.remaining_capacity ??
                e.capacity;

            html += `

                <div class="card fade-in">

                    ${
                        e.image_url
                        ?
                        `
                        <img
                            src="${e.image_url}"
                            class="event-image">
                        `
                        :
                        ""
                    }
=======
<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
=======
>>>>>>> ce25f670b89a25dd008aea6d4aae2b8058309c49
>>>>>>> aa5d16b6e567a8aaff7c06c7e9e3255d2c4d890c
>>>>>>> 94a7a18f1bf8c674dd8860b156b541530868c5d1
        const events =
            await res.json();

        let html = "";

<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> 94a7a18f1bf8c674dd8860b156b541530868c5d1
        events.forEach((e) => {

            const full =
                e.availableSeats <= 0;

            const percent =
                (e.availableSeats / e.capacity) * 100;

            html += `

    <div class="card fade-in">

        ${
            e.image_url
            ?
            `
            <img
                src="${e.image_url}"
                class="event-image">
            `
            :
            ""
        }

        <h3>
            ${e.title}
        </h3>

        <p>
            📍 ${e.venue}
        </p>

        <p>
            📅 ${new Date(
                e.event_date
            ).toLocaleString()}
        </p>

        <p>
            💲 ${e.price_per_ticket}
        </p>

        <p>
            🎟 Cupos disponibles:
              ${e.remaining_capacity}
        </p>

        <button
            onclick="book(${e.id_event})">

            Reservar

        </button>

    </div>
`;
<<<<<<< HEAD
=======
=======
<<<<<<< HEAD
        events.forEach((e) => {
=======
        events.forEach(e => {
>>>>>>> ce25f670b89a25dd008aea6d4aae2b8058309c49

            html += `
                <div class="card">
>>>>>>> 877167939f9e10d949c292c821688475df3ee5be

                    <h3>
                        ${e.title}
                    </h3>

                    <p>
                        📍 ${e.venue}
                    </p>

                    <p>
<<<<<<< HEAD
                        📅 ${new Date(
                            e.event_date
                        ).toLocaleString()}
                    </p>

                    <p>
=======
>>>>>>> 877167939f9e10d949c292c821688475df3ee5be
                        💲 ${e.price_per_ticket}
                    </p>

                    <p>
<<<<<<< HEAD
                        🎟 Cupos disponibles:
                        ${availableSeats}
=======
                        👥 ${e.capacity} cupos
>>>>>>> 877167939f9e10d949c292c821688475df3ee5be
                    </p>

                    <button
                        onclick="book(${e.id_event})">

                        Reservar

                    </button>

                </div>
            `;
<<<<<<< HEAD
=======
>>>>>>> aa5d16b6e567a8aaff7c06c7e9e3255d2c4d890c
>>>>>>> 94a7a18f1bf8c674dd8860b156b541530868c5d1
>>>>>>> 877167939f9e10d949c292c821688475df3ee5be
        });

        document.getElementById(
            "events"
        ).innerHTML = html;

    } catch (error) {

        console.log(error);

        showMessage(
            "No se pudieron cargar eventos"
        );
    }
}
<<<<<<< HEAD
=======

>>>>>>> 877167939f9e10d949c292c821688475df3ee5be
//
// RESERVAR
//
async function book(idEvent) {

    const quantity =
        prompt(
            "Cantidad:"
        );

<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> 94a7a18f1bf8c674dd8860b156b541530868c5d1
>>>>>>> 877167939f9e10d949c292c821688475df3ee5be
    if (
        quantity === null ||
        quantity === "" ||
        parseInt(quantity) <= 0
    ) {

        showMessage(
            "Cantidad inválida"
        );

        return;
    }

<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
=======
    const userId =
        prompt(
            "Tu userId:"
        );

>>>>>>> aa5d16b6e567a8aaff7c06c7e9e3255d2c4d890c
>>>>>>> 94a7a18f1bf8c674dd8860b156b541530868c5d1
>>>>>>> 877167939f9e10d949c292c821688475df3ee5be
    try {

        const res = await fetch(
            `${BASE_URL}/api/bookings`,
            {
                method: "POST",

                headers: {
                    "Content-Type":
                        "application/json",

                    Authorization:
                        "Bearer " + token()
                },

                body: JSON.stringify({
                    eventId: idEvent,
<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
                    userId: parseInt(userId),
>>>>>>> aa5d16b6e567a8aaff7c06c7e9e3255d2c4d890c
>>>>>>> 94a7a18f1bf8c674dd8860b156b541530868c5d1
>>>>>>> 877167939f9e10d949c292c821688475df3ee5be
                    quantity: parseInt(quantity)
                })
            }
        );

<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> 94a7a18f1bf8c674dd8860b156b541530868c5d1
>>>>>>> 877167939f9e10d949c292c821688475df3ee5be
        //
        // SI FALLA
        //
        if (!res.ok) {

            const errorText =
                await res.text();

            showMessage(
                errorText ||
                "No hay suficientes cupos"
            );

            return;
        }

        //
        // SI TODO SALE BIEN
        //
        showMessage(
            "Reserva creada exitosamente 🎉"
        );

        // RECARGAR EVENTOS
        loadEvents();

        // RECARGAR RESERVAS
        loadBookings();

    } catch (error) {

        console.log(error);

        showMessage(
            "Error creando reserva"
        );
    }
}
<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
=======
        if (res.ok) {

            showMessage(
                "Reserva creada"
            );

        } else {

            showMessage(
                "No hay cupos disponibles"
            );
        }

    } catch (error) {

        console.log(error);
    }
}

>>>>>>> aa5d16b6e567a8aaff7c06c7e9e3255d2c4d890c
>>>>>>> 94a7a18f1bf8c674dd8860b156b541530868c5d1
>>>>>>> 877167939f9e10d949c292c821688475df3ee5be
//
// CARGAR RESERVAS
//
async function loadBookings() {

    try {

        const res = await fetch(
            `${BASE_URL}/api/bookings/my`,
            {
                headers: {
                    Authorization:
                        "Bearer " + token()
                }
            }
        );

        const bookings =
            await res.json();

        let html = "";

<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> aa5d16b6e567a8aaff7c06c7e9e3255d2c4d890c
>>>>>>> 94a7a18f1bf8c674dd8860b156b541530868c5d1
>>>>>>> 877167939f9e10d949c292c821688475df3ee5be
        const activeBookings =
            bookings.filter(
                b => b.status !== "CANCELLED"
            );

        if (
            activeBookings.length === 0
        ) {

            html =
                `
                <p>
                    No tienes reservas activas
                </p>
                `;
        }

        activeBookings.forEach((b) => {
<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
=======
        bookings.forEach(b => {
>>>>>>> ce25f670b89a25dd008aea6d4aae2b8058309c49
>>>>>>> aa5d16b6e567a8aaff7c06c7e9e3255d2c4d890c
>>>>>>> 94a7a18f1bf8c674dd8860b156b541530868c5d1
>>>>>>> 877167939f9e10d949c292c821688475df3ee5be

            html += `
                <div class="card">

                    <h3>
                        ${b.event.title}
                    </h3>

                    <p>
                        🎟 Cantidad:
                        ${b.quantity}
                    </p>

                    <p>
                        💲 Total:
                        ${b.total_amount}
                    </p>

                    <p>
                        📌 Estado:
                        ${b.status}
                    </p>

                    <button
<<<<<<< HEAD
                        onclick="cancelBooking(${b.id_booking})">
=======
<<<<<<< HEAD
                        onclick="cancelBooking(${b.id_booking})">
=======
<<<<<<< HEAD
                        onclick="cancelBooking(${b.id_booking})">
=======
<<<<<<< HEAD
                        onclick="cancelBooking(${b.id_booking})">
=======
                        onclick="cancelBooking(
                            ${b.id_booking}
                        )">
>>>>>>> ce25f670b89a25dd008aea6d4aae2b8058309c49
>>>>>>> aa5d16b6e567a8aaff7c06c7e9e3255d2c4d890c
>>>>>>> 94a7a18f1bf8c674dd8860b156b541530868c5d1
>>>>>>> 877167939f9e10d949c292c821688475df3ee5be

                        Cancelar

                    </button>

                </div>
            `;
        });

        document.getElementById(
            "bookings"
        ).innerHTML = html;

    } catch (error) {

        console.log(error);

        showMessage(
<<<<<<< HEAD
            "Error cargando reservas"
=======
<<<<<<< HEAD
            "Error cargando reservas"
=======
<<<<<<< HEAD
            "Error cargando reservas"
=======
<<<<<<< HEAD
            "Error cargando reservas"
=======
            "No se pudieron cargar reservas"
>>>>>>> ce25f670b89a25dd008aea6d4aae2b8058309c49
>>>>>>> aa5d16b6e567a8aaff7c06c7e9e3255d2c4d890c
>>>>>>> 94a7a18f1bf8c674dd8860b156b541530868c5d1
>>>>>>> 877167939f9e10d949c292c821688475df3ee5be
        );
    }
}

//
// CANCELAR
//
async function cancelBooking(id) {

    try {

        await fetch(
            `${BASE_URL}/api/bookings/${id}`,
            {
                method: "DELETE",

                headers: {
                    Authorization:
                        "Bearer " + token()
                }
            }
        );

        showMessage(
            "Reserva cancelada"
        );

<<<<<<< HEAD
        loadBookings();

=======
<<<<<<< HEAD
        loadBookings();

=======
<<<<<<< HEAD
        loadBookings();

=======
<<<<<<< HEAD
        loadBookings();

=======
>>>>>>> ce25f670b89a25dd008aea6d4aae2b8058309c49
>>>>>>> aa5d16b6e567a8aaff7c06c7e9e3255d2c4d890c
>>>>>>> 94a7a18f1bf8c674dd8860b156b541530868c5d1
>>>>>>> 877167939f9e10d949c292c821688475df3ee5be
    } catch (error) {

        console.log(error);
    }
}

//
<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> aa5d16b6e567a8aaff7c06c7e9e3255d2c4d890c
>>>>>>> 94a7a18f1bf8c674dd8860b156b541530868c5d1
>>>>>>> 877167939f9e10d949c292c821688475df3ee5be
// CREAR EVENTO
//
//
// CREAR O ACTUALIZAR EVENTO
//
async function saveEvent() {

    const title =
        document.getElementById(
            "eventTitle"
        ).value;

    const description =
        document.getElementById(
            "eventDescription"
        ).value;

    const date =
        document.getElementById(
            "eventDate"
        ).value;

    const venue =
        document.getElementById(
            "eventVenue"
        ).value;

    const capacity =
        document.getElementById(
            "eventCapacity"
        ).value;

    const price =
        document.getElementById(
            "eventPrice"
        ).value;

    if (
        title === "" ||
        description === "" ||
        date === "" ||
        venue === "" ||
        capacity === "" ||
        price === ""
    ) {

        showMessage(
            "Completa todos los campos"
        );

        return;
    }

    // VALIDAR FECHA
    const selectedDate =
        new Date(date);

    const now =
        new Date();

    if (selectedDate < now) {

        showMessage(
            "No puedes usar fechas pasadas"
        );

        return;
    }

    const eventData = {

        title: title,

        description: description,

        event_date: date,

        venue: venue,

        capacity:
            parseInt(capacity),

        price_per_ticket:
            parseFloat(price)
    };

    // CREAR O EDITAR
    let url =
        `${BASE_URL}/api/events`;

    let method =
        "POST";

    if (editingEventId) {

        url =
            `${BASE_URL}/api/events/${editingEventId}`;

        method =
            "PUT";
    }

    try {

        const res =
            await fetch(
                url,
                {
                    method: method,

                    headers: {
                        "Content-Type":
                            "application/json",

                        Authorization:
                            "Bearer " + token()
                    },

                    body: JSON.stringify(
                        eventData
                    )
                }
            );

        if (res.ok) {

            showMessage(
                editingEventId
                    ? "Evento actualizado"
                    : "Evento creado"
            );

            // LIMPIAR FORM
            document.getElementById(
                "eventTitle"
            ).value = "";

            document.getElementById(
                "eventDescription"
            ).value = "";

            document.getElementById(
                "eventDate"
            ).value = "";

            document.getElementById(
                "eventVenue"
            ).value = "";

            document.getElementById(
                "eventCapacity"
            ).value = "";

            document.getElementById(
                "eventPrice"
            ).value = "";

            editingEventId = null;

            loadAdminEvents();

        } else {

            showMessage(
                "Error guardando evento"
            );
        }

    } catch (error) {

        console.log(error);

        showMessage(
            "Error del servidor"
        );
    }
}
//
// EDITAR EVENTO
//
//
// EDITAR EVENTO
//
<<<<<<< HEAD
var editingEventId = null;
=======
<<<<<<< HEAD
var editingEventId = null;
=======
let editingEventId = null;
>>>>>>> 94a7a18f1bf8c674dd8860b156b541530868c5d1
>>>>>>> 877167939f9e10d949c292c821688475df3ee5be

async function editEvent(id) {

    try {

        const res =
            await fetch(
                `${BASE_URL}/api/events/${id}`,
                {
                    headers: {
                        Authorization:
                            "Bearer " + token()
                    }
                }
            );

        const e =
            await res.json();

        // LLENAR FORMULARIO
        document.getElementById(
            "eventTitle"
        ).value = e.title;

        document.getElementById(
            "eventDescription"
        ).value = e.description;

        document.getElementById(
            "eventDate"
        ).value = e.event_date;

        document.getElementById(
            "eventVenue"
        ).value = e.venue;

        document.getElementById(
            "eventCapacity"
        ).value = e.capacity;

        document.getElementById(
            "eventPrice"
        ).value = e.price_per_ticket;

        editingEventId = id;

        showMessage(
            "Editando evento..."
        );

    } catch (error) {

        console.log(error);

        showMessage(
            "Error cargando evento"
        );
    }
}
//
// ELIMINAR EVENTO
//
async function deleteEvent(id) {

    const confirmDelete =
        confirm(
            "¿Eliminar evento?"
        );

    if (!confirmDelete) {

        return;
    }

<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> 877167939f9e10d949c292c821688475df3ee5be
    //
    // DEBUG
    //
    console.log(
        "TOKEN:",
        token()
    );

    console.log(
        "ROLE:",
        role()
    );

<<<<<<< HEAD
=======
=======
>>>>>>> 94a7a18f1bf8c674dd8860b156b541530868c5d1
>>>>>>> 877167939f9e10d949c292c821688475df3ee5be
    try {

        const res =
            await fetch(
                `${BASE_URL}/api/events/${id}`,
                {
                    method: "DELETE",

                    headers: {
<<<<<<< HEAD
                        "Authorization":
=======
<<<<<<< HEAD
                        "Authorization":
=======
                        Authorization:
>>>>>>> 94a7a18f1bf8c674dd8860b156b541530868c5d1
>>>>>>> 877167939f9e10d949c292c821688475df3ee5be
                            "Bearer " + token()
                    }
                }
            );

        if (res.ok) {

            showMessage(
<<<<<<< HEAD
                "Evento eliminado ✅"
=======
<<<<<<< HEAD
                "Evento eliminado ✅"
=======
                "Evento eliminado"
>>>>>>> 94a7a18f1bf8c674dd8860b156b541530868c5d1
>>>>>>> 877167939f9e10d949c292c821688475df3ee5be
            );

            loadAdminEvents();

        } else {

<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> 877167939f9e10d949c292c821688475df3ee5be
            console.log(
                "STATUS:",
                res.status
            );

<<<<<<< HEAD
=======
=======
>>>>>>> 94a7a18f1bf8c674dd8860b156b541530868c5d1
>>>>>>> 877167939f9e10d949c292c821688475df3ee5be
            showMessage(
                "Error eliminando"
            );
        }

    } catch (error) {

        console.log(error);
    }
}

<<<<<<< HEAD
//
=======
<<<<<<< HEAD
//
=======

//
<<<<<<< HEAD
=======
=======
>>>>>>> ce25f670b89a25dd008aea6d4aae2b8058309c49
>>>>>>> aa5d16b6e567a8aaff7c06c7e9e3255d2c4d890c
>>>>>>> 94a7a18f1bf8c674dd8860b156b541530868c5d1
>>>>>>> 877167939f9e10d949c292c821688475df3ee5be
// LOGOUT
//
function logout() {

    localStorage.removeItem(
        "token"
    );

    localStorage.removeItem(
        "username"
    );

<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> aa5d16b6e567a8aaff7c06c7e9e3255d2c4d890c
>>>>>>> 94a7a18f1bf8c674dd8860b156b541530868c5d1
>>>>>>> 877167939f9e10d949c292c821688475df3ee5be
    localStorage.removeItem(
        "role"
    );

<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> 94a7a18f1bf8c674dd8860b156b541530868c5d1
>>>>>>> 877167939f9e10d949c292c821688475df3ee5be
    window.location.href =
        "index.html";
}

//
// ABRIR MODAL
//
function openEditModal(event) {

    document.getElementById(
        "editModal"
    ).style.display = "block";

    document.getElementById(
        "editId"
    ).value = event.id_event;

    document.getElementById(
        "editTitle"
    ).value = event.title;

    document.getElementById(
        "editDescription"
    ).value = event.description;

    document.getElementById(
        "editDate"
    ).value =
        event.event_date?.slice(0,16);

    document.getElementById(
        "editVenue"
    ).value = event.venue;

    document.getElementById(
        "editCapacity"
    ).value = event.capacity;

    document.getElementById(
        "editPrice"
    ).value =
        event.price_per_ticket;
}

//
// CERRAR MODAL
//
function closeModal() {

    document.getElementById(
        "editModal"
    ).style.display = "none";
}

//
// ACTUALIZAR EVENTO
//
async function updateEvent() {

    const id =
        document.getElementById(
            "editId"
        ).value;

    const title =
        document.getElementById(
            "editTitle"
        ).value;

    const description =
        document.getElementById(
            "editDescription"
        ).value;

    const event_date =
        document.getElementById(
            "editDate"
        ).value;

    const venue =
        document.getElementById(
            "editVenue"
        ).value;

    const capacity =
        document.getElementById(
            "editCapacity"
        ).value;

    const price_per_ticket =
        document.getElementById(
            "editPrice"
        ).value;

    try {

        const res = await fetch(
            `${BASE_URL}/api/events/${id}`,
            {
                method: "PUT",

                headers: {
                    "Content-Type":
                        "application/json",

                    Authorization:
                        "Bearer " + token()
                },

                body: JSON.stringify({
                    title,
                    description,
                    event_date,
                    venue,
                    capacity:
                        parseInt(capacity),

                    price_per_ticket:
                        parseFloat(price_per_ticket)
                })
            }
        );

        if (res.ok) {

            showMessage(
                "Evento actualizado 🎉"
            );

            closeModal();

            loadAdminEvents();

        } else {

            showMessage(
                "Error actualizando"
            );
        }

    } catch (error) {

        console.log(error);
    }
<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
=======
=======
>>>>>>> ce25f670b89a25dd008aea6d4aae2b8058309c49
    window.location.href =
        "index.html";
>>>>>>> aa5d16b6e567a8aaff7c06c7e9e3255d2c4d890c
>>>>>>> 94a7a18f1bf8c674dd8860b156b541530868c5d1
>>>>>>> 877167939f9e10d949c292c821688475df3ee5be
}