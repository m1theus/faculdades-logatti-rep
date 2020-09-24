<%@ Page Title="" Language="C#" MasterPageFile="~/Principal.Master" AutoEventWireup="true" CodeBehind="EmployeeForm.aspx.cs" Inherits="Client.EmployeeForm" %>
<asp:Content ID="Content2" ContentPlaceHolderID="ContentPlaceHolder" runat="server">
    <link rel="stylesheet" href="https://code.jquery.com/ui/1.9.0/themes/base/jquery-ui.css" />
    <script src="https://code.jquery.com/jquery-1.8.2.js"></script>
    <script src="https://code.jquery.com/ui/1.9.0/jquery-ui.js"></script>
    <div class="container">
        <form id="form" runat="server">
            <div class="row">
                <div class="col-12">
                    <div class="form-group">
                        <asp:Label ID="lblMensagem" runat="server" Text=""></asp:Label>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-2">
                    <div class="form-group">
                        <asp:Label ID="lblId" runat="server" Text="ID"></asp:Label>
                        <asp:TextBox class="form-control" ReadOnly="true" ID="txtId" runat="server"></asp:TextBox>
                    </div>
                </div>
                <div class="col-5">
                   <div class="form-group">
                       <asp:Label ID="Label1" runat="server" Text="Role"></asp:Label>
                        <asp:DropDownList CssClass="form-control" ID="ddlRole" runat="server"></asp:DropDownList>
                   </div>
                </div>
                <div class="col-5">
                    <div class="form-group">
                        <asp:Label ID="lblDescricao" runat="server" Text="Name"></asp:Label>
                        <asp:TextBox class="form-control" MaxLength="100" ID="txtDescricao" runat="server"></asp:TextBox>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-12">
                    <div class="form-group">
                        <asp:Button class="btn btn-primary" ID="btnSalvar" runat="server" Text="Save" OnClick="btnSalvar_Click" />
                        <asp:Button class="btn btn-warning" ID="btnLimpar" runat="server" Text="Clear" OnClick="btnLimpar_Click" />
                        <asp:Button class="btn btn-success" ID="btnVoltar" runat="server" Text="Back" OnClick="btnVoltar_Click" />
                    </div>
                </div>
            </div>
        </form>
    </div>
</asp:Content>
