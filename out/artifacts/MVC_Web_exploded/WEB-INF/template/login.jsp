<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
   <link rel="stylesheet" href="style.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <title>Document</title>
</head>
<body>
<div class="wrapper">
    <div class="title-text">
        <div class="title login">
            Login Form
        </div>

    </div>
    <div class="form-container">
        <div class="form-inner">
            <form action="/auth/login" method="post" class="login">
                <div class="field">
                    <input type="phone" name="phoneNumber" placeholder="Phone" required>
                </div>
                <div class="field">
                    <input type="password" name="password" placeholder="Password" required>
                </div>


                <div class="field btn">
                    <div class="btn-layer"></div>
                    <input type="submit" value="Login">
                </div>
                <a href="/" class="field btn">
                    <div class="btn-layer"></div>
                    <p  >Register</p>
                </a>

            </form>

        </div>

    </div>
</div>

<style>
    @import url('https://fonts.googleapis.com/css?family=Poppins:400,500,600,700&display=swap');
    *{
        margin: 0;
        padding: 0;
        box-sizing: border-box;
        font-family: 'Poppins', sans-serif;
    }
    html,body{
        display: grid;
        height: 100%;
        width: 100%;
        place-items: center;
        background: -webkit-linear-gradient(left, #a445b2, #fa4299);
    }
    ::selection{
        background: #fa4299;
        color: #fff;
    }
    .wrapper{
        overflow: hidden;
        max-width: 390px;
        background: #fff;
        padding: 30px;
        border-radius: 5px;
        box-shadow: 0px 15px 20px rgba(0,0,0,0.1);
    }
    .wrapper .title-text{
        display: flex;
        width: 200%;
    }
    .wrapper .title{
        width: 50%;
        font-size: 35px;
        font-weight: 600;
        text-align: center;
        transition: all 0.6s cubic-bezier(0.68,-0.55,0.265,1.55);
    }
    .wrapper .slide-controls{
        position: relative;
        display: flex;
        height: 50px;
        width: 100%;
        overflow: hidden;
        margin: 30px 0 10px 0;
        justify-content: space-between;
        border: 1px solid lightgrey;
        border-radius: 5px;
    }
    .slide-controls .slide{
        height: 100%;
        width: 100%;
        color: #fff;
        font-size: 18px;
        font-weight: 500;
        text-align: center;
        line-height: 48px;
        cursor: pointer;
        z-index: 1;
        transition: all 0.6s ease;
    }
    .slide-controls label.signup{
        color: #000;
    }
    .slide-controls .slider-tab{
        position: absolute;
        height: 100%;
        width: 50%;
        left: 0;
        z-index: 0;
        border-radius: 5px;
        background: -webkit-linear-gradient(left, #a445b2, #fa4299);
        transition: all 0.6s cubic-bezier(0.68,-0.55,0.265,1.55);
    }
    input[type="radio"]{
        display: none;
    }
    #signup:checked ~ .slider-tab{
        left: 50%;
    }
    #signup:checked ~ label.signup{
        color: #fff;
        cursor: default;
        user-select: none;
    }
    #signup:checked ~ label.login{
        color: #000;
    }
    #login:checked ~ label.signup{
        color: #000;
    }
    .login{
        cursor: default;
        user-select: none;
    }
    .wrapper .form-container{
        width: 100%;
        overflow: hidden;
    }
    .form-container .form-inner{
        display: flex;
        width: 200%;
    }
    .form-container .form-inner form{
        width: 50%;
        transition: all 0.6s cubic-bezier(0.68,-0.55,0.265,1.55);
    }
    .form-inner form .field{
        height: 50px;
        width: 100%;
        margin-top: 20px;
    }
    .form-inner form .field input{
        height: 100%;
        width: 100%;
        outline: none;
        padding-left: 15px;
        border-radius: 5px;
        border: 1px solid lightgrey;
        border-bottom-width: 2px;
        font-size: 17px;
        transition: all 0.3s ease;
    }
    .form-inner form .field input:focus{
        border-color: #fc83bb;
        /* box-shadow: inset 0 0 3px #fb6aae; */
    }
    .form-inner form .field input::placeholder{
        color: #999;
        transition: all 0.3s ease;
    }
    form .field input:focus::placeholder{
        color: #b3b3b3;
    }
    .form-inner form .pass-link{
        margin-top: 5px;
    }
    .form-inner form .signup-link{
        text-align: center;
        margin-top: 30px;
    }
    .form-inner form .pass-link a,
    .form-inner form .signup-link a{
        color: #fa4299;
        text-decoration: none;
    }
    .form-inner form .pass-link a:hover,
    .form-inner form .signup-link a:hover{
        text-decoration: underline;
    }
    form .btn{
        height: 50px;
        width: 100%;
        border-radius: 5px;
        position: relative;
        overflow: hidden;
    }
    .btn-layer{
        height: 100%;
        width: 300%;
        position: absolute;
        left: -100%;
        background: -webkit-linear-gradient(right, #a445b2, #fa4299, #a445b2, #fa4299);
        border-radius: 5px;
        transition: all 0.4s ease;;
    }
    .btn:hover .btn-layer{
        left: 0;
    }
    form .btn input[type="submit"]{
        height: 100%;
        width: 100%;
        z-index: 1;
        position: relative;
        background: none;
        border: none;
        color: #fff;
        padding-left: 0;
        border-radius: 5px;
        font-size: 20px;
        font-weight: 500;
        cursor: pointer;
    }
    form .btn p{
        height: 100%;
        width: 100%;
        z-index: 1;
        position: relative;
        background: none;
        border: none;
        color: #fff;
        padding-left: 0;
        border-radius: 5px;
        font-size: 20px;
        font-weight: 500;
        cursor: pointer;
    }


    .avatar-wrapper {
        position: relative;
        height: 70px;
        width: 70px;

        border-radius: 50%;
        overflow: hidden;
        box-shadow: 1px 1px 15px -5px black;
        transition: all 0.3s ease;
    }
    .avatar-wrapper:hover {
        transform: scale(1.05);
        cursor: pointer;
    }
    .avatar-wrapper:hover .profile-pic {
        opacity: 0.5;
    }
    .avatar-wrapper .profile-pic {
        height: 100%;
        width: 100%;
        transition: all 0.3s ease;
    }
    .avatar-wrapper .profile-pic:after {
        font-family: FontAwesome;
        content: "";
        top: 0;
        left: 0;
        width: 100%;
        height: 100%;
        position: absolute;
        font-size: 190px;
        background: #ecf0f1;
        color: #34495e;
        text-align: center;
    }
    .avatar-wrapper .upload-button {
        position: absolute;
        top: 0;
        left: 0;
        height: 100%;
        width: 100%;
    }
    .avatar-wrapper .upload-button .fa-arrow-circle-up {
        position: absolute;
        font-size: 234px;
        top: -17px;
        left: 0;
        text-align: center;
        opacity: 0;
        transition: all 0.3s ease;
        color: #34495e;
    }
    .avatar-wrapper .upload-button:hover .fa-arrow-circle-up {
        opacity: 0.9;
    }
</style>

</body>
</html>