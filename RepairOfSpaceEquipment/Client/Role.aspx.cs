using System;
using System.Collections.Generic;
using System.Drawing;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace Client
{
    public partial class Role : Page
    {
        DBRepairSpaceEquipmentEntities context = new DBRepairSpaceEquipmentEntities();
        protected void Page_Load(object sender, EventArgs e)
        {
            LoadGridView();
        }
        protected void GVResult_RowCommand(object sender, GridViewCommandEventArgs e)
        {
            int idItem = int.Parse(e.CommandArgument.ToString());
            lblSelectedId.Text = idItem.ToString();
            if (e.CommandName == "ALTERAR")
            {
                Response.Redirect("RoleForm.aspx?id=" + idItem);
            }
            else if (e.CommandName == "EXCLUIR")
            {
                DisplayModal(this);
            }
        }
        protected void btnConfirm_Click(object sender, EventArgs e)
        {
            try
            {
                int id = Convert.ToInt32(lblSelectedId.Text);
                var role = context.role.First(x => x.id == id);
                if (role.employee.ToList().Count() > 0)
                {
                    SendMessage("Não é possível excluir está 'Role', pois há vinculo com um 'Employee'.", Color.Red);
                    return;
                }
                context.role.Remove(context.role.First(x => x.id == id));
                context.SaveChanges();
                SendMessage("Registro excluído com sucesso.", Color.Green);
                LoadGridView();
            }
            catch (Exception ex)
            {
                SendMessage($"Ocorreu um erro inesperado: {ex.Message}", Color.Red);
            }
        }
        private void LoadGridView()
        {
            gvResult.DataSource = context.role.ToList();
            gvResult.DataBind();
        }
        private void DisplayModal(Page page)
        {
            ClientScript.RegisterStartupScript(typeof(Page), Guid.NewGuid().ToString(), "openModalConfirmation();", true);
        }
        private void SendMessage(string message, Color color)
        {
            lblMensagem.Text = message;
            lblMensagem.ForeColor = color;
            lblMensagem.Font.Bold = true;
        }

        protected void btnRegister_Click(object sender, EventArgs e) => Response.Redirect("RoleForm.aspx");
    }
}