/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function criarImagem(id, nome, imagem) {
    lu = document.getElementById("lista_imagens");
    p = document.createElement("p");
    p.innerHTML = id+": "+nome;
    input = document.createElement('input');
    input.setAttribute('type', "submit");
    input.setAttribute('value', "Info");
    form = document.createElement("form");
    form.appendChild(input);
    form.setAttribute("method", "post");
    form.setAttribute("action", "Reconhecimento");
    img = document.createElement("img");
    img.setAttribute('src', imagem);
    img.setAttribute('width', "80px");
    img.setAttribute('height', "80px");
    img.setAttribute('title', nome);
    li = document.createElement("li");
    li.setAttribute('display', "inline");
    li.appendChild(img);
    li.appendChild(p);
    li.appendChild(form);
    li.appendChild(document.createElement("br"));
    lu.appendChild(li);
}




function criarListaDeImagens() {
    lu = document.getElementById("lista_imagens");
    for (i = 0; i < 10; i++) {
        nome = "Minha Imagem ";
        p = document.createElement("p");
        p.innerHTML = nome + i;
        input = document.createElement('input');
        input.setAttribute('type', "submit");
        input.setAttribute('value', "Info");
        form = document.createElement("form");
        form.setAttribute('method', "get");
        form.setAttribute('action', 'dados_da_imagem.html');
        form.appendChild(input);
        img = document.createElement("img");
        img.setAttribute('src', "img_padrao.jpg");
        img.setAttribute('width', "50px");
        img.setAttribute('height', "50px");
        img.setAttribute('title', nome + i);
        li = document.createElement("li");
        li.setAttribute('display', "inline");
        li.appendChild(img);
        li.appendChild(p);
        li.appendChild(form);
        li.appendChild(document.createElement("br"));
        lu.appendChild(li);
        lu.appendChild(document.createElement("br"));
    }
}

function criarlistaReconhecimento(nome, local) {
    form = document.getElementById("form_reconhecimento");
    for (i = 1; i < 2; i++) {
        nome = "Modelo de Padrão ";
        checkbox = document.createElement("input");
        checkbox.setAttribute('type', "checkbox");
        checkbox.setAttribute('name', "tipo_reconhecimento");
        img = document.createElement("img");
        img.setAttribute('src', "/recimg/static/img/image_estrela.jpg");
        img.setAttribute('width', "150px");
        img.setAttribute('height', "150px");
        img.setAttribute('title', nome + i);
        div = document.createElement("div");
        div.setAttribute('id', "div_reconhecimento");
        p = document.createElement("p");
        p.innerHTML = nome + i;
        div.display = "inline";
        div.appendChild(img);
        div.appendChild(document.createElement("br"));
        div.appendChild(checkbox);
        div.appendChild(p);
        form.appendChild(div);
        form.appendChild(document.createElement("br"));

    }
    btn = document.createElement('input');
    btn.setAttribute('type', "submit");
    btn.setAttribute('value', "Reconhecer Imagem");
    btn.setAttribute('class', "formInput");
    form.appendChild(btn);
    form.appendChild(document.createElement("br"));
}

function criarListaResultado(img, result) {
    lu = document.getElementById("lista_resultado");
    for (i = 1; i < 2; i++) {
        lu.appendChild(document.createElement("hr"));
        nome = "Modelo de Padrão ";
        li = document.createElement("li");
        img = document.createElement("img");
        img.setAttribute('src', "/recimg/static/img/image_estrela.jpg");
        img.setAttribute('width', "75px");
        img.setAttribute('height', "75px");
        img.setAttribute('title', nome + i);
        item = document.createElement("p");
        item.innerHTML = nome + i;
        chance = document.createElement("p");
        chanceNome = "Chance de Acerto: ";
        chance.innerHTML = chanceNome + String(result) + "%";
        li.appendChild(img);
        li.appendChild(item);
        li.appendChild(chance);
        li.style.margin = "20px";
        lu.appendChild(li);
    }
    lu.appendChild(document.createElement("hr"));
    btn = document.createElement('input');
    btn.setAttribute('type', "submit");
    btn.setAttribute('value', "Salvar Resultado");
    btn.setAttribute('class', "formInput");
    form = document.getElementById("resultado");
    form.appendChild(btn);
    content = document.getElementById("sub_content");
    content.appendChild(form);
    content.appendChild(document.createElement("br"));
}

function validar(senha1, senha2) {
    senha1 = document.getElementById(senha1).value;
    senha2 = document.getElementById(senha2).value;
    nome = document.getElementById("nome");
    user = document.getElementById("username");
    isTermo = document.getElementById("termos").checked;
    if (senha1 === senha2) {
        if (confirm("Finalizar?")) {
            location.replace("index.html");
            return true;
        }
    } else {
        alert("Senhas não são iguais!");
        senha2.style.border = "red";
    }
    return false;
}

function sucesso(){
    alert("Usuario criado com sucesso");
}



