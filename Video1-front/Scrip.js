const API_URL = 'http://localhost:8080/api/users';
const form = document.getElementById('user-form');
const nameInput = document.getElementById('name');
const emailInput = document.getElementById('email');
const idInput = document.getElementById('id');
const userList = document.getElementById('user-list');

window.onload = () => {
    fetchUsers();
};


form.addEventListener('submit', async (e) => {
    e.preventDefault();

const user = {
    name: nameInput.value,
    email: emailInput.value
};

if (idInput.value) {
    await fetch(`${API_URL}/${idInput.value}`, {
    method: 'PUT',
    headers: { 'Content-Type': 'application/json' },
    body: JSON.stringify(user)
    });
    idInput.value = '';
} else {
    await fetch(API_URL, {
    method: 'POST',
    headers: { 'Content-Type': 'application/json' },
    body: JSON.stringify(user)
    });
}

    fetchUsers();
    form.reset();
});

async function fetchUsers() {
const res = await fetch(API_URL);
const users = await res.json();
userList.innerHTML = '';

users.forEach(user => {
const li = document.createElement('li');
li.className = 'user-item';

    li.innerHTML = `
    <div>
        <h3>${user.name}</h3>
        <small>${user.email}</small>
    </div>
    <div class="actions">
        <button onclick="editUser(${JSON.stringify(user)})">Editar</button>
        <button onclick="deleteUser(${user.id})" class="delete">Excluir</button>
    </div>
    `;

    userList.appendChild(li);
});
}

window.editUser = (user) => {
    nameInput.value = user.name;
    emailInput.value = user.email;
    idInput.value = user.id;
};

window.deleteUser = async (id) => {
    if (confirm('Tem certeza que deseja excluir este usuário?')) {
    await fetch(`${API_URL}/${id}`, {
        method: 'DELETE'
    });
    fetchUsers();
}
};