<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% 
    String navbar = (String) request.getAttribute("navbar"); 
%>


<section class="hero is-info is-small">
    <div class="hero-head">
        <header class="nav">
            <div class="container">
                <div class="nav-left">
                    <a class="nav-item">
                        <img src="images/bulma-type-white.png" alt="Logo">
                    </a>
                </div>
                <span class="nav-toggle">
                    <span></span>
                    <span></span>
                    <span></span>
                </span>
                <div class="nav-right nav-menu">
                    <a class="nav-item is-active">
                        Account
                    </a>
                    <span class="nav-item">
                        <a class="button is-info is-inverted">
                            <span class="icon">
                                <i class="fa fa-sign-out" aria-hidden="true"></i>
                            </span>
                            <span>Logout</span>
                        </a>
                    </span>
                </div>
            </div>
        </header>
    </div>

    <!-- Hero content: will be in the middle -->
    <div class="hero-body">
        <div class="container has-text-centered">
            <h1 class="title">
                PRJ321
            </h1>
            <h2 class="subtitle">
                QuyTa
            </h2>
        </div>
    </div>

    <!-- Hero footer: will stick at the bottom -->
    <div class="hero-foot">
        <nav class="tabs is-boxed is-fullwidth">
            <div class="container">
                <ul>
                    <li<% if (navbar.equals("home")) { %> class="is-active" <% } %>>
                        <a href="/PRJ321_Test2/">Home</a>
                    </li>
        
                    <li<% if (navbar.equals("account.list")) { %> class="is-active" <% } %>>
                        <a href="/PRJ321_Test2/account/list">Users</a>
                    </li>
                </ul>
            </div>
        </nav>
    </div>
</section>
