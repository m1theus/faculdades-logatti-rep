﻿using System;
using System.Drawing;
using System.Linq;

namespace Client
{
    public partial class EquipmentForm : System.Web.UI.Page
    {
        DBRepairSpaceEquipmentEntities context = new DBRepairSpaceEquipmentEntities();
        
        protected void Page_Load(object sender, EventArgs e)
        {
            if (!IsPostBack)
            {
                txtDescricao.Focus();
                LoadDataPage();
            }
        }
        protected void btnSalvar_Click(object sender, EventArgs e)
        {
            try
            {
                if (!string.IsNullOrWhiteSpace(txtId.Text))
                {
                    int id = int.Parse(txtId.Text);
                    equipment equipmentResult = context.equipment.First(x => x.id == id);
                    equipmentResult.descricao = txtDescricao.Text;
                    SendMessage("Registro alterado com sucesso.", Color.Green);
                }
                else
                {
                    equipment equipment = new equipment()
                    {
                        descricao = txtDescricao.Text,
                    };
                    context.equipment.Add(equipment);
                    SendMessage("Registro criado com sucesso.", Color.Green);
                }
                context.SaveChanges();
                ResetForm(true);
            }
            catch (Exception ex)
            {
                SendMessage($"Ocorreu um erro inesperado: {ex.Message}", Color.Red);
            }

        }
        protected void btnLimpar_Click(object sender, EventArgs e)
        {
            lblMensagem.Text = String.Empty;
            ResetForm(false);
        }
        private void ResetForm(bool clearId)
        {
            if (clearId)
            {
                txtId.Text = String.Empty;
            }
            txtDescricao.Text = String.Empty;
        }
        private void LoadDataPage()
        {
            string id = Request.QueryString["id"];
            if (!String.IsNullOrEmpty(id))
            {
                int newId = Convert.ToInt32(id);
                var equipmentResult = context.equipment.First(x => x.id == newId);
                txtId.Text = equipmentResult.id.ToString();
                txtDescricao.Text = equipmentResult.descricao;
            }
        }
        private void SendMessage(string message, Color color)
        {
            lblMensagem.Text = message;
            lblMensagem.ForeColor = color;
            lblMensagem.Font.Bold = true;
        }

        protected void btnVoltar_Click(object sender, EventArgs e) => Response.Redirect("Equipment.aspx");
    }
}